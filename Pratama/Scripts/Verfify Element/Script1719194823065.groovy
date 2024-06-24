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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://sendbird-uikit-react.netlify.app/group_channel?appId=37C8DB25-8B44-435F-A528-5BA9B9965FD0&userId=Pratama17&nickname=Pratama17')

WebUI.click(findTestObject('Object Repository/Verify Element/Page_Testing App/span_Pratama16'))

WebUI.verifyElementText(findTestObject('Object Repository/Verify Element/Page_Testing App/span_Pratama16'), 'Pratama16')

WebUI.click(findTestObject('Object Repository/Verify Element/Page_Testing App/div_Hello'))

WebUI.verifyElementText(findTestObject('Object Repository/Verify Element/Page_Testing App/div_Hello'), 'Hello')

WebUI.verifyElementPresent(findTestObject('Verify Element/Page_Testing App/Verifypngclick'), 2)

WebUI.verifyElementPresent(findTestObject('Verify Element/Page_Testing App/Verifyjpegclick'), 0)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Verify Element/Page_Testing App/div_FileTxt.txt_sendbird-message-input-text-field'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Verify Element/Page_Testing App/div_FileTxt.txt_sendbird-message-input-text-field'), 
    'test')

WebUI.sendKeys(findTestObject('Object Repository/Verify Element/Page_Testing App/div_FileTxt.txt_sendbird-message-input-text-field'), 
    Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Object Repository/Verify Element/Page_Testing App/span_FileTxt.txt'), 3)

WebUI.click(findTestObject('Object Repository/Verify Element/Page_Testing App/span_FileTxt.txt'))

WebUI.closeBrowser()

