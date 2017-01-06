package stack.AlgoBook;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfix {

    static class Token {
        private TokenType tok;
        private String lexeme;

        public Token(TokenType tok, String lexeme) {
            this.tok = tok;
            this.lexeme = lexeme;
        }

        public TokenType getTokenType()
        {
            return tok;
        }

        public String getLexeme()
        {
            return lexeme;
        }

        @Override
        public String toString()
        {
            return lexeme;
        }
    }

    enum TokenType {
        operand,
        left_par,
        right_par,
        mul_operator,
        div_operator,
        add_operator,
        sub_operator,
        pow_operator
    }

    public static void printPostfix(ArrayList<Token> tokens) {
        Stack<Token> operatorStack = new Stack<>();
        while(tokens.size() != 0) {
            Token a = tokens.remove(0);
            if(a.getTokenType() == TokenType.operand)
                System.out.print(a + " ");
            else if(operatorStack.isEmpty() || a.getTokenType() == TokenType.left_par)
                operatorStack.push(a);
            else if(a.getTokenType() == TokenType.right_par) {
                boolean foundLeftPar = false;
                while(foundLeftPar == false) {
                    Token token = operatorStack.pop();
                    if(token.getTokenType() == TokenType.left_par)
                        foundLeftPar = true;
                    else
                        System.out.print(token + " ");
                }
            }
            else if(a.getTokenType() == TokenType.add_operator || a.getTokenType() == TokenType.sub_operator
                    || a.getTokenType() == TokenType.mul_operator || a.getTokenType() == TokenType.div_operator
                    || a.getTokenType() == TokenType.pow_operator)
                insertOperator(operatorStack, a);
        }

        while(operatorStack.isEmpty() == false)
            System.out.print(operatorStack.pop() + " ");
    }

    private static void insertOperator(Stack<Token> operatorStack, Token token) {
        if (operatorStack.isEmpty() == false) {
            Token top = operatorStack.peek();
            if (top.getTokenType() != TokenType.left_par) {
                if (token.getTokenType() == TokenType.add_operator || token.getTokenType() == TokenType.sub_operator) {
                    if (top.getTokenType() == TokenType.mul_operator || top.getTokenType() == TokenType.div_operator
                            || token.getTokenType() == TokenType.pow_operator) {
                        System.out.print(operatorStack.pop() + " ");
                        insertOperator(operatorStack, token);
                    } else if (top.getTokenType() == TokenType.add_operator || top.getTokenType() == TokenType.sub_operator) {
                        System.out.print(operatorStack.pop() + " ");
                        operatorStack.push(token);
                    }
                } else if (token.getTokenType() == TokenType.mul_operator || token.getTokenType() == TokenType.div_operator) {
                    if (top.getTokenType() == TokenType.add_operator || top.getTokenType() == TokenType.sub_operator)
                        operatorStack.push(token);
                    else if (top.getTokenType() == TokenType.pow_operator) {
                        System.out.print(operatorStack.pop());
                        insertOperator(operatorStack, token);
                    } else if (top.getTokenType() == TokenType.mul_operator || top.getTokenType() == TokenType.div_operator) {
                        System.out.print(operatorStack.pop() + " ");
                        operatorStack.push(token);
                    }
                } else if (token.getTokenType() == TokenType.pow_operator) {
                    if (top.getTokenType() == TokenType.add_operator || top.getTokenType() == TokenType.sub_operator
                            || top.getTokenType() == TokenType.mul_operator
                            || top.getTokenType() == TokenType.div_operator)
                        operatorStack.push(token);
                    else if (top.getTokenType() == TokenType.pow_operator) {
                        System.out.print(operatorStack.pop() + " ");
                        operatorStack.push(token);
                    }
                }
            }
            else
                operatorStack.push(token);
        }
        else
            operatorStack.push(token);
    }

    public static ArrayList<Token> tokenize(String expr) {
        ArrayList<Token> tokens = new ArrayList<>();
        int index = 0;
        TokenType tok = null;
        String lexeme = null;
        index = skipWhiteSpace(expr, index);
        while (index != expr.length()) {
            index = skipWhiteSpace(expr, index);
            if(Character.isDigit(expr.charAt(index))) {
                int i = index;
                while (i < expr.length() && Character.isDigit(expr.charAt(i)))
                    i++;
                lexeme = expr.substring(index, i);
                index = i;
                tok = TokenType.operand;
            }

            else if (expr.charAt(index) == '*') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.mul_operator;
                index++;
            }

            else if (expr.charAt(index) == '/') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.div_operator;
                index++;
            }

            else if (expr.charAt(index) == '+') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.add_operator;
                index++;
            }

            else if (expr.charAt(index) == '-') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.sub_operator;
                index++;
            }

            else if (expr.charAt(index) == '(') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.left_par;
                index++;
            }

            else if (expr.charAt(index) == ')') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.right_par;
                index++;
            }

            else if (expr.charAt(index) == '^') {
                lexeme = new Character(expr.charAt(index)).toString();
                tok = TokenType.pow_operator;
                index++;
            }

            Token t = new Token(tok, lexeme);
            tokens.add(t);
        }
        return tokens;
    }

    private static int skipWhiteSpace(String line, int index)
    {
        assert line != null;
        assert index >= 0;
        while (index < line.length() && Character.isWhitespace(line.charAt(index)))
            index++;
        return index;
    }
}
