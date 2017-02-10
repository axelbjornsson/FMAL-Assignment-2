import java.util.*;
public class Lexer {
    private String leftovers = "";
    private Scanner scanner = new Scanner(System.in);
    public Lexer() {
        scanner.useDelimiter("");
    }
    public Token nextToken() {
        String str = recurse(leftovers);
        if(str.isEmpty())
            return null;
        return lexemeToToken(str);
    }

    private String recurse(String string) {
        if(!scanner.hasNext())
            return "";        
        String tmp = string + scanner.next();
        if( tmp.trim().isEmpty()) {
            tmp = tmp.trim();
        }
        if (isVarClass(tmp) || isNumber(tmp) || tmp.isEmpty() ) {
            return recurse(tmp);
        }
        if (tmp.length() > 1) {
            leftovers = tmp.substring(tmp.length()-1, tmp.length()).trim();
            tmp = tmp.substring(0,tmp.length()-1);
            return tmp;
        }
        return recurse(tmp);
    }

    private Token lexemeToToken(String str) {
        if (str.equals("+")) {
            return new Token(str, TokenCode.ADD);
        } else if (str.equals("-")) {
            return new Token(str, TokenCode.SUB);
        } else if (str.equals("*")) {
            return new Token(str, TokenCode.MULT);
        } else if (str.equals("(")) {
            return new Token(str, TokenCode.LPAREN);
        } else if (str.equals(")")) {
            return new Token(str, TokenCode.RPAREN);
        } else if (str.equals("=")) {
            return new Token(str, TokenCode.ASSIGN);
        } else if (str.equals(";")) {
            return new Token(str, TokenCode.SEMICOL);
        } else if (str.equals("end")) {
            return new Token(str, TokenCode.END);
        } else if (str.equals("print")) {
            return new Token(str, TokenCode.PRINT);
        } else if (isVarClass(str)) {
            return new Token(str, TokenCode.ID);
        } else if (isNumber(str)) {
            return new Token(str, TokenCode.INT);
        } else {
            return new Token(str, TokenCode.ERROR);
        }
    } 
    private boolean isVarClass(String s) {
        return (s.matches("[A-Za-z0-9]+") && s.indexOf(0).matches("[A-Za-z]+"));
    }
    private boolean isNumber(String s) {
        return s.matches("[0-9]+");
    }
}
