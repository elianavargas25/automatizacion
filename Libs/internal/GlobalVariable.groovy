package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : Url para ingresar a la aplicaci&oacute;n de cobro coactivo
Profile Eliana : Url para ingresar a la aplicaci&oacute;n de cobro coactivo</p>
     */
    public static Object Url
     
    /**
     * <p></p>
     */
    public static Object Delay
     
    /**
     * <p></p>
     */
    public static Object TimeOut
     
    /**
     * <p></p>
     */
    public static Object hostQITS
     
    /**
     * <p></p>
     */
    public static Object hostQX
     
    /**
     * <p></p>
     */
    public static Object nameQITS
     
    /**
     * <p></p>
     */
    public static Object nameQX
     
    /**
     * <p></p>
     */
    public static Object portQITS
     
    /**
     * <p></p>
     */
    public static Object portQX
     
    /**
     * <p></p>
     */
    public static Object userNameQITS
     
    /**
     * <p></p>
     */
    public static Object userNameQX
     
    /**
     * <p></p>
     */
    public static Object passwordQX
     
    /**
     * <p></p>
     */
    public static Object passwordQITS
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            Url = selectedVariables['Url']
            Delay = selectedVariables['Delay']
            TimeOut = selectedVariables['TimeOut']
            hostQITS = selectedVariables['hostQITS']
            hostQX = selectedVariables['hostQX']
            nameQITS = selectedVariables['nameQITS']
            nameQX = selectedVariables['nameQX']
            portQITS = selectedVariables['portQITS']
            portQX = selectedVariables['portQX']
            userNameQITS = selectedVariables['userNameQITS']
            userNameQX = selectedVariables['userNameQX']
            passwordQX = selectedVariables['passwordQX']
            passwordQITS = selectedVariables['passwordQITS']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
