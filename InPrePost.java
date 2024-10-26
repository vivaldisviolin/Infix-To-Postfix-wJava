package structure;

public class InPrePost {
    public void infixtopostfix(String infix){
        Stack stack = new Stack(infix.length());
        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                System.out.print(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    System.out.print(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    System.out.print(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek());
                    stack.pop();
        }
    }

    private int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}