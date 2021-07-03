import java.util.List;

public class Father
{
    public Mother wife; //Geheimnisprinzip verletzt
    private List<Child> children;

    public boolean hasChild(Child child)
    {
        return children.contains(child);
    }
}

public class Mother
{
    private Father husband; // Zyklische Abhängigkeit
    private List<Child> children;

    public List<Child> printAndGetChildren() //Niedrige Kohäsion
    {
        for (Child child : children)
        {
            System.out.println(child.name); // UI in einer Fachklasse
        }
        return children;
    }
}

public class Child
{
    public String name; // Geheimnisprinzip verletzt
    private Father dad; // Zyklische Abhängigkeit
    private Mother mum; // Zyklische Abhängigkeit

    public boolean isStepChild()
    {
        return !(dad.hasChild(this) && dad.wife.printAndGetChildren()
            .contains(this)); // Law of Demetra verletzt             
    }
}