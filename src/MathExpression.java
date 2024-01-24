import java.util.Stack;

public class MathExpression {

    public static void main(String[] args) {
        String expression="12+14*10+120";
        var exp=new MathExpression();
        var result = exp.getResult(expression);
        System.out.println(result);
    }

    enum Operator{
        ADD,SUBTRACT,MULTIPLY,DIVIDE,BLANK;
    }

    public double getResult(String expression){
        var numStack = new Stack<Double>();
        var opStack=new Stack<Operator>();
        for(int i=0;i<expression.length();i++){
            String number=parseNumber(expression,i);
            i+=number.length();
            numStack.push(Double.valueOf(number));
            if(i>=expression.length())break;

            Operator op=parseOperator(expression,i);
            updateOperator(op,numStack,opStack);
            opStack.push(op);
        }
        updateOperator(Operator.BLANK,numStack,opStack);
        if(numStack.size()==1&& opStack.size()==0){
            return numStack.pop();
        }
        return 0;
    }

    public int getPriority(Operator op){
        switch(op){
            case ADD:
            case SUBTRACT:
                return 1;
            case DIVIDE:
            case MULTIPLY:
                return 2;
            case BLANK:return 0;
        }
        return 0;
    }
    public void updateOperator(Operator currentOp,Stack<Double> numStack, Stack<Operator> opStack){
        while (numStack.size()>=2 && opStack.size()>=1){
            if(getPriority(currentOp)<=getPriority(opStack.peek())){
                double first=numStack.pop();
                double second=numStack.pop();
                Operator op=opStack.pop();
                numStack.push(performOperation(op,first,second));
            }else{
                break;
            }

        }
    }

    public Operator parseOperator(String expression, int i)
    {
        if(i<expression.length()){
            char ch=expression.charAt(i);
            switch(ch){
                case '+':return Operator.ADD;
                case '-':return Operator.SUBTRACT;
                case '*':return Operator.MULTIPLY;
                case '/':return Operator.DIVIDE;

            }
        }
        return Operator.BLANK;
    }

    public double performOperation(Operator op, double left, double right){
        switch (op){
            case ADD: return left+right;
            case SUBTRACT: return left-right;
            case MULTIPLY: return left*right;
            case DIVIDE: return left/right;
        }
        return right;
    }

    public boolean isNotOperator(String expression, int i){
            return parseOperator(expression,i)==Operator.BLANK;
    }

    public String parseNumber(String expression, int i){
        var sb=new StringBuilder();
        for(int j=i;j<expression.length() && isNotOperator(expression,j);j++){
            sb.append(expression.charAt(j));
        }
        return sb.toString();
    }
}
