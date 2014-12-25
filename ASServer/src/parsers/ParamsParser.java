
package parsers;

import java.util.HashMap;

/**
 *
 * @author Diego Gabriel
 */
public class ParamsParser {
    public HashMap <String, String> parse(String params){
        HashMap<String, String> paramsMap = new HashMap <>();
        String[] paramsTokens = params.split("&");
            for (String aToken : paramsTokens){
                
                String[] param = aToken.split("=");
                
                if (param.length == 2)
                    paramsMap.put(param[0], param[1]);
            }
        return paramsMap;
    }
}
