class Compiler {    
    public static void main(String[] args) {
        Lexer myLexer = new Lexer();
        Parser myParser = new Parser(myLexer);
        myParser.parse();
        System.out.println("\n" + myParser.string);

        
    }
}