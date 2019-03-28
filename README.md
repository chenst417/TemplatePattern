# TemplatePattern
模板模式                          
1、思考：模板模式除了继承以外，还有哪些实现方式？                  
 JDK1.8之后接口有默认实现方法。可以实现模板模式。



/**
 * 吃饭
 */
public interface IEat {

    default void execute(){
        cook();
        eat();
        wash();
    }
    default void cook(){
        System.out.println("做饭。");
    }

    void eat();

    default void wash(){
        System.out.println("刷锅刷碗。");
    }
}


public class EatFish implements IEat {
    @Override
    public void eat() {
        System.out.println("吃鱼。");
    }
}


public class EatRice implements IEat {
    @Override
    public void eat() {
        System.out.println("吃米饭。");
    }
}





public class IEatTest {

    public static void main(String[] args) {
        IEat eatFish = new EatFish();
        eatFish.execute();

        System.out.println("=======================");
        
        IEat eatRice = new EatRice();
        eatRice.execute();
    }
}



