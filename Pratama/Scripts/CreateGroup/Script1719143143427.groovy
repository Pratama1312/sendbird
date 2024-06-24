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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('UrlUserGet').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Pratama16'))

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Save'))

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/svg_1'))

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Group'))

WebUI.waitForElementClickable(findTestObject('CreateGroup/Page_Testing App/ObjPratama18'), 2)

WebUI.check(findTestObject('CreateGroup/Page_Testing App/ObjPratama18'))

WebUI.delay(4)

WebUI.waitForElementClickable(findTestObject('CreateGroup/Page_Testing App/ObjPratama17'), 2)

WebUI.check(findTestObject('CreateGroup/Page_Testing App/ObjPratama17'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Create'))

WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Pratama16, Pratama17 and Pratama18 joined'))

WebUI.verifyElementText(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Pratama16, Pratama17 and Pratama18 joined'), 
    'Pratama16, Pratama17 and Pratama18 joined.')

WebUI.delay(3)

for (def rowNum = 1; rowNum <= findTestData('UploadPNG').getRowNumbers(); rowNum++) {
    if (rowNum == 1) {
        WebUI.setText(findTestObject('Object Repository/CreateGroup/Page_Testing App/div_Pratama16, Pratama17 and Pratama18 join_bef2c2'), 
            findTestData('UploadPNG').getValue(1, rowNum))

        WebUI.sendKeys(findTestObject('Object Repository/CreateGroup/Page_Testing App/div_Pratama16, Pratama17 and Pratama18 join_bef2c2'), 
            Keys.chord(Keys.ENTER))

        WebUI.click(findTestObject('Object Repository/CreateGroup/Page_Testing App/span_Pratama18, Pratama17'))
    } else {
        WebUI.delay(3)

        def filePath1 = findTestData('UploadPNG').getValue(1, rowNum)

        WebUI.uploadFile(findTestObject('test/Page_Testing App/Page_Testing App/svg'), filePath1)
    }
}

//WebUI.uploadFile(findTestObject('test/Page_Testing App/Page_Testing App/svg'), filePath)
WebUI.delay(10, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

