package parsers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deigo-gabriel
 */
public class PDTParserTest {
    

    @Test
    public void testParseEmpty(){
        String input = "";
        PDTParser parser = new PDTParser();
        String[][][] expected = new String[0][0][0];
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
    
    
    @Test
    public void testParseOK_1table(){
        String input = "1|2|3|1|2|3|4|5|6";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
    
    
    @Test
    public void testParseOK_2tables(){
        String input = "2|2|3|1|2|3|4|5|6|1|2|7|8";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}},
                                {{"7", "8"}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
     public void testParseOK_trailingSpaces(){
        String input = "    2|2|3|1|2|3|4|5|6|1|2|7|8    ";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}},
                                {{"7", "8"}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
    
     @Test
    public void testParseOK_emptydata(){
        String input = "    2|2|3|1|2|3|4|5|6|1|2||8    ";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}},
                                {{"", "8"}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
    
     @Test
    public void testParseOK_emptydata2(){
        String input = "    2|2|3|1|2|3|4|5|6|1|2||    ";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}},
                                {{"", ""}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }@Test
    public void testParseOK_FromForm(){
        String input = "  data-form=   2|2|3|1|2|3|4|5|6|1|2||    ";
        PDTParser parser = new PDTParser();
        String[][][] expected = {{{"1", "2", "3"},
				{"4", "5", "6"}},
                                {{"", ""}}};
        try{
            assertArrayEquals(expected, parser.parse(input));
        } catch (PDTInputNotParseable e){
            e.printStackTrace();
            fail();
        }
            
    }
    
    
    @Test
    public void testParseFail(){
        String input = "1|2!!!|3|1|2|3|4|5|6!";
        PDTParser parser = new PDTParser();
        
        try{
            String[][][] tables = parser.parse(input);
            fail("La operacion termino con exito. No deberia");
        } catch (PDTInputNotParseable e){
            assertTrue(true);
        }
            
    }

    
    
}
