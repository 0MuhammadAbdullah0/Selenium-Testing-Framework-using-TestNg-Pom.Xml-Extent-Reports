    package com.guru99.utilities;

    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.ExtentTest;
    import com.aventstack.extentreports.Status;
    import com.aventstack.extentreports.markuputils.ExtentColor;
    import com.aventstack.extentreports.markuputils.MarkupHelper;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
    import com.aventstack.extentreports.reporter.configuration.Theme;
    import org.codehaus.plexus.util.FileUtils;
    import org.testng.ITestContext;
    import org.testng.ITestResult;
    import org.testng.TestListenerAdapter;

    import java.io.File;
    import java.io.IOException;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    import static java.lang.System.getProperty;

    public class reporting extends TestListenerAdapter {

        public ExtentReports extent;
        public ExtentTest logger;
        public ExtentSparkReporter reporter;


        public void onStart(ITestContext context)
        {
            String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String repname= "/Test-report" + timestamp + ".html";
            reporter=new ExtentSparkReporter("./test-output" + repname);
            try {
                reporter.loadXMLConfig("src/main/resources/extent-config.xml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            extent=new ExtentReports();

            extent.attachReporter(reporter);
            extent.setSystemInfo("Hostname","localHost");
            extent.setSystemInfo("Envoirment","QA");
            extent.setSystemInfo("User","Abdullah");

            reporter.config().setDocumentTitle("Guru99 Framework Report");
            reporter.config().setReportName("Functional Testing report");
            reporter.config().setTheme(Theme.DARK);

        }
        public void onTestSuccess(ITestResult tr)
        {
            logger=extent.createTest(tr.getName());
            logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

        }
        public void onTestFailure(ITestResult tr)
        {
            logger=extent.createTest(tr.getName());
            logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

            String screenshotdir = "./ScreenShot/" ;
            String screenshotFilename=tr.getName() + ".png";
            System.out.println(tr.getName());
            String screenshotPath = screenshotdir + screenshotFilename;

            File sourceFile = new File("ScreenShot/" + screenshotFilename);
            File destFile = new File(screenshotPath);

            try {
                if (sourceFile.exists()) {
                    FileUtils.copyFile(sourceFile, destFile);
                    if (destFile.exists()) {
                        logger.fail("ScreenShot is below" + logger.addScreenCaptureFromPath(screenshotPath));
                    }
                } else {
                    // If screenshot doesn't exist, simply log the failure without adding a screenshot
                    logger.fail("Test failed - No screenshot available");
                    logger.fail(tr.getThrowable());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void onTestSkipped(ITestResult tr)
        {
            logger=extent.createTest(tr.getName());
            logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
        }
        public void onFinish(ITestContext testContext)
        {
            extent.flush();
        }


    }
