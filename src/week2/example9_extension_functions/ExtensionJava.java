package week2.example9_extension_functions;

import week2.example9_extension_functions.definition.ExtensionDefinitionsKt;

public class ExtensionJava {
    public static void main(String[] args) {
        //From Java extension function is just a static function
        //Can make static import
        char c = ExtensionDefinitionsKt.lastChar("abc");
        System.out.println(c);
        String str = ExtensionDefinitionsKt.repeat("Abc", 3);
        System.out.println(str);
    }
}
