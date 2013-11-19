public class Rational {
    public int top , bot;

    //constructors
    public Rational () {
	top = 0;
	bot = 1;
    }
    public Rational (int p, int q) {
	this();
	if (q == 0) 
	    System.out.println("invalid denominator, undefined");
	else {
	    top = p;
	    bot = q;
	}
    }

    public String toString () {
	return top + "/" + bot;
    }
    public float floatValue () {
	return (float) top / bot;
    }
    public void multiply (Rational num) {
	String inp = num.toString();
	int slash = inp.indexOf("/");
	//b4 slash = p, aft = q
	top *= Integer.parseInt(inp.substring(0, slash));
	bot *= Integer.parseInt(inp.substring(slash+1));
    }
    public void divide (Rational num) {
	String inp = num.toString();
	int slash = inp.indexOf("/");
	bot *= Integer.parseInt(inp.substring(0, slash));
	top *= Integer.parseInt(inp.substring(slash+1));
    }

    //phase II
    public void add (Rational num) {
	String inp = num.toString();
	int slash = inp.indexOf("/");
	int p = Integer.parseInt(inp.substring(0,slash));
	int q = Integer.parseInt(inp.substring(slash+1));
	top = top * q + p * bot;
	bot *= q;
    }
    public void subtract (Rational num) {
	String inp = num.toString();
	int slash = inp.indexOf("/");
	int p = Integer.parseInt(inp.substring(0,slash));
	int q = Integer.parseInt(inp.substring(slash+1));
	top = top * q - p * bot;
	bot *= q;
    }
    public int gcd () {
	int factor;
	if (top % bot == 0) 
	    factor = bot;
	else 
	    factor = gcd(bot, top % bot);
	return factor;
    }
    public void reduce () {
	top /= gcd();
	bot /= gcd();
    }
    //phase III
    public int compareTo (Rational num) {
	if (floatValue() == num.floatValue()) 
	    return 0;
	else if (floatValue() > num.floatValue())
	    return 1;
	else
	    return -1;
    }
    public static int gcd (int a, int b) {
	int factor;
	if (a % b == 0) {
	    factor = b;
	}
	else {
	    factor = gcd(b, a % b);
	}
	return factor;
    }
    public static void main (String[] args) {
	Rational r = new Rational (2,3);
	System.out.println(r);
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2 
	//r.multiply(new Rational(s.bot,s.bot));
	//System.out.println(s.top * r.bot);
	System.out.println(r);
	System.out.println(s);
	t.reduce();
	System.out.println(t);
	/*
	//System.out.println(r.floatValue());
	r.divide(new Rational(1,2));
	System.out.println(r);
	*/

    }
}
