import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream

WebUI.openBrowser('')
WebUI.navigateToUrl(findTestData('TestData').getValue(3, 1))
WebUI.waitForElementPresent(findTestObject('Create User/Page_Testing App/input_appId_appId'), 30)
WebUI.maximizeWindow()

// Inisialisasi workbook dan sheet di luar loop
String filePath = 'D:\\Pratama\\Pratama\\Data Files\\UrlUser.xlsx'
Workbook workbook = new XSSFWorkbook()
Sheet sheet = workbook.createSheet('Sheet1')

// Buat header
Row header = sheet.createRow(0)
header.createCell(0).setCellValue("Url User")

for (def rowNum = 1; rowNum <= findTestData('TestData').getRowNumbers(); rowNum++) {
    WebUI.clearText(findTestObject('Object Repository/Create User/Page_Testing App/input_appId_appId'))
    WebUI.click(findTestObject('Object Repository/Create User/Page_Testing App/input_appId_appId'))
    WebUI.setText(findTestObject('Object Repository/Create User/Page_Testing App/input_appId_appId'), findTestData('TestData').getValue(4, 1))

    WebUI.clearText(findTestObject('Object Repository/Create User/Page_Testing App/input_userId_userId'), FailureHandling.STOP_ON_FAILURE)
    WebUI.setText(findTestObject('Object Repository/Create User/Page_Testing App/input_userId_userId'), findTestData('TestData').getValue(1, rowNum))

    WebUI.clearText(findTestObject('Object Repository/Create User/Page_Testing App/input_nickname_nickname'), FailureHandling.STOP_ON_FAILURE)
    WebUI.setText(findTestObject('Object Repository/Create User/Page_Testing App/input_nickname_nickname'), findTestData('TestData').getValue(2, rowNum))

    WebUI.click(findTestObject('Object Repository/Create User/Page_Testing App/button_Copy'))
    WebUI.clearText(findTestObject('Object Repository/Create User/Page_Testing App/input_userId_userId'), FailureHandling.STOP_ON_FAILURE)
    WebUI.setText(findTestObject('Object Repository/Create User/Page_Testing App/input_userId_userId'), Keys.chord(Keys.CONTROL, 'v'))
    WebUI.delay(5)

    // Ambil teks dari field userId menggunakan getAttribute
    String url = WebUI.getAttribute(findTestObject('Object Repository/Create User/Page_Testing App/input_userId_userId'), 'value')
    println("URL yang diambil: " + url) // Debugging output untuk memeriksa apakah URL diambil dengan benar

    // Buat row baru di Excel sheet
    Row row = sheet.createRow(rowNum)
    Cell cell = row.createCell(0)
    cell.setCellValue(url)
}

// Simpan file Excel di luar loop
FileOutputStream fileOut = new FileOutputStream(filePath)
workbook.write(fileOut)
fileOut.close()
workbook.close()

println("Data berhasil ditulis ke file Excel")

// Tutup browser
WebUI.closeBrowser()
