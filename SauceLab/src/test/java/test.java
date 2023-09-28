import org.testng.Assert;

public class test {
    public static void main(String[] args) {
        String string1 = "using equals ignore case";
        String string2 = "USING EQUALS IGNORE CASE";
        Assert.assertEquals(string1, string2);



    }
}

