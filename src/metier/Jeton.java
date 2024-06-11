package metier;

public class Jeton 
{
    private IRessources type;
    
    public Jeton(IRessources type)
    {
        this.type = type;
    }

    public IRessources getType() 
    {
        return type;
    }
}
