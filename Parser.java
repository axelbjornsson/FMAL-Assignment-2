import java.io.IOException;

class Parser {
    private Lexer myLexer;
    private Token currToken;
    public String string = "";

    public Parser(Lexer lexer) {
        this.myLexer = lexer;        
    }
    public void parse() {
        currToken = myLexer.nextToken();
        if (currToken != null) {
            System.out.println(currToken.lexeme);            
            System.out.println(currToken.tCode);
            if (currToken.tCode == TokenCode.ID) {
                string += "PUSH " + currToken.lexeme + "\n";
            } else if (currToken.tCode == TokenCode.INT) {
                string += "PUSH " + currToken.lexeme + "\n";
            } else if (currToken.tCode == TokenCode.ASSIGN) {
                Token tmpToken = currToken;
                parse();
                string += "ASSIGN\n";
            } else if (currToken.tCode == TokenCode.ADD) {
                parse();
                string += "ADD\n";
            } else if (currToken.tCode == TokenCode.SUB) {
                parse();
                string += "SUB\n";
            } else if (currToken.tCode == TokenCode.MULT) {
                parse();
                string += "MULT\n";                
            } else if (currToken.tCode == TokenCode.SEMICOL) {
                return;
            } else if (currToken.tCode == TokenCode.LPAREN) {
                // TODO
            } else if (currToken.tCode == TokenCode.RPAREN) {
                // TODO 
            } else if (currToken.tCode == TokenCode.PRINT) {
                // TODO
            } else if (currToken.tCode == TokenCode.END) {
                return;
            }
            parse();
        }
    }
}