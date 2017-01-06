package stack.AlgoBook;

import org.junit.Test;

import java.util.ArrayList;

import static stack.AlgoBook.InfixToPostfix.printPostfix;
import static stack.AlgoBook.InfixToPostfix.tokenize;

/**
 * Created by Winston on 10/25/16.
 */
public class InfixToPostfixTest {

    @Test
    public void print() {
        String expr = "10 + 5";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
//        for(InfixToPostfix.Token t:tokens)
//            System.out.println(t);
        printPostfix(tokens);
        System.out.print("\n");
    }

    @Test
    public void print2() {
        String expr = "3 * 5 + 2";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
        printPostfix(tokens);
        System.out.print("\n");
    }

    @Test
    public void print3() {
        String expr = "10 * (5 + 2)";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
        printPostfix(tokens);
        System.out.print("\n");
    }

    @Test
    public void print4() {
        String expr = "7 - 3 + 1";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
        printPostfix(tokens);
        System.out.print("\n");
    }

    @Test
    public void print5() {
        String expr = "22 * 40 ^ 6 + 8";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
        printPostfix(tokens);
        System.out.print("\n");
    }

    @Test
    public void print6() {
        String expr = "22 * (40 + 6 * 8) + 12";
        ArrayList<InfixToPostfix.Token> tokens = tokenize(expr);
        printPostfix(tokens);
        System.out.print("\n");
    }
}
