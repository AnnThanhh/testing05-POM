package utils;

import com.aventstack.extentreports.ExtentReports; // Thư viện chính của ExtentReports
import com.aventstack.extentreports.reporter.ExtentSparkReporter; // Dùng để tạo file HTML
import com.aventstack.extentreports.reporter.configuration.Theme; // Dùng để chọn giao diện (theme)

public class ExtentManager {
    // Tạo biến static ExtentReports để dùng toàn cục
    private static ExtentReports extent;

    // Hàm khởi tạo ExtentReports instance
    public static ExtentReports createInstance(String reportFileName) {
        // Đường dẫn file HTML sẽ được tạo ra
//        String reportPath = "./reports/ExtentReport.html";
        String reportPath = "./reports/" + reportFileName;

        // Tạo đối tượng ExtentSparkReporter, dùng để xuất ra file HTML
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

        // Thiết lập tiêu đề file HTML
        reporter.config().setDocumentTitle("Automation Test Report");

        // Thiết lập tên hiển thị cho báo cáo
        reporter.config().setReportName("Test Results");

        // Chọn theme cho báo cáo: STANDARD (trắng) hoặc DARK (đen)
        reporter.config().setTheme(Theme.STANDARD);

        // Khởi tạo đối tượng ExtentReports chính
        extent = new ExtentReports();

        // Gắn reporter đã cấu hình ở trên vào ExtentReports
        extent.attachReporter(reporter);

        // Gắn thông tin phụ thêm vào report (hiển thị ở phần trên cùng)
        extent.setSystemInfo("Tester", "Trịnh An Thành");
        extent.setSystemInfo("Environment", "Production");

        // Trả về đối tượng ExtentReports
        return extent;
    }
}
