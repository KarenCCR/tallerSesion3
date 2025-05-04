package factoryBrowser;

import java.util.HashMap;
import java.util.Map;

public class FactoryBrowser {

    public static IBrowser make(String type){
         Map<String,IBrowser> browserMap = new HashMap<>();
         browserMap.put("chrome",new Chrome());
         browserMap.put("proxy",new ChromeProxy());
         browserMap.put("firefox",new Firefox());

         return browserMap.containsKey(type.toLowerCase())?
                browserMap.get(type.toLowerCase()):
                new Chrome() ;
    }
}
