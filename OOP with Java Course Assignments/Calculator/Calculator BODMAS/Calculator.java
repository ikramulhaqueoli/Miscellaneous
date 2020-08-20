import java.lang.*;
import java.util.*;
public class Calculator
{
	public static double calculateExpression(String expression)
	{
		ArrayList expr = new ArrayList();
		expr.add('(');
		for(int i = 0; i < expression.length(); i++)
		{
			double num = 0; int sign = 1;
			if(expression.charAt(i) == '-')
			{
				if(i == 0 || expression.charAt(i-1) == '(')
				{
					sign = -1;
					i++;
				}
				else expr.add(expression.charAt(i));
			}
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
			{
				int j = i;
				while(j < expression.length() && (expression.charAt(j) >= '0' && expression.charAt(j) <= '9'))
				{
					num = ((num*10) + (int)(expression.charAt(j)-'0'));
					j++;
				}
				if(j < expression.length() && expression.charAt(j) == '.')
				{
					j++;
					double fracNum = 0, dec = 1;
					while(j < expression.length() && (expression.charAt(j) >= '0' && expression.charAt(j) <= '9'))
					{
						fracNum = ((fracNum*10) + (int)(expression.charAt(j)-'0'));
						dec *= 10;
						j++;
					}
					num += (fracNum/dec);
				}
				num *= sign;
				expr.add(num);
				i = j-1;
			}
			else if(expression.charAt(i) != '-')
			{
				expr.add(expression.charAt(i));
			}
		}
		expr.add(')');
		int opLast = expr.lastIndexOf('('), clFirst = expr.indexOf(')');
		while(opLast >= 0 && clFirst >= 0)
		{
			System.out.println(opLast + " " + clFirst);
			System.out.println(expr);
			while(expr.subList(opLast, clFirst+1).indexOf('^') >= 0)
			{
				for(int i = opLast+1; i < clFirst; i++)
				{
					if(expr.get(i).equals('^'))
					{
						double res = Math.pow((double)expr.get(i-1), (double)expr.get(i+1));
						expr.subList(i-1, i+2).clear();
						expr.add(i-1, res);
						opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
						break;
					}
				}
				System.out.println(expr);
			}
			while(expr.subList(opLast, clFirst+1).indexOf('/') >= 0)
			{
				for(int i = opLast+1; i < clFirst; i++)
				{
					if(expr.get(i).equals('/'))
					{
						double res = (double)expr.get(i-1) / (double)expr.get(i+1);
						expr.subList(i-1, i+2).clear();
						expr.add(i-1, res);
						opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
						break;
					}
				}
				System.out.println(expr);
			}
			while(expr.subList(opLast, clFirst+1).indexOf('x') >= 0)
			{
				for(int i = opLast+1; i < clFirst; i++)
				{
					if(expr.get(i).equals('x'))
					{
						double res = (double)expr.get(i-1) * (double)expr.get(i+1);
						expr.subList(i-1, i+2).clear();
						expr.add(i-1, res);
						opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
						break;
					}
				}
				System.out.println(expr);
			}
			while(expr.subList(opLast, clFirst+1).indexOf('-') >= 0)
			{
				for(int i = opLast+1; i < clFirst; i++)
				{
					if(expr.get(i).equals('-'))
					{
						double res = (double)expr.get(i-1) - (double)expr.get(i+1);
						expr.subList(i-1, i+2).clear();
						expr.add(i-1, res);
						opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
						break;
					}
				}
				System.out.println(expr);
			}
			while(expr.subList(opLast, clFirst+1).indexOf('+') >= 0)
			{
				for(int i = opLast+1; i < clFirst; i++)
				{
					if(expr.get(i).equals('+'))
					{
						double res = (double)expr.get(i-1) + (double)expr.get(i+1);
						expr.subList(i-1, i+2).clear();
						expr.add(i-1, res);
						opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
						break;
					}
				}
				System.out.println(expr);
			}
			expr.remove(expr.lastIndexOf('('));
			expr.remove(expr.indexOf(')'));
			opLast = expr.lastIndexOf('('); clFirst = expr.indexOf(')');
		}
		return (double)expr.get(0);
	}
}