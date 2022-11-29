package AbstractFactoryPattern;

public class AndroidPhone extends Phone {

    @Override
    public void call() {
        System.out.println("녹음은 되나 녹음이 불법이 될 수도 있으니 소용없다");

    }

    @Override
    public void complete() {
        System.out.println("안드 폰 완성");
    }

    @Override
    public void playGame() {
        System.out.println("안드에 기본 게임이 있나?");
    }
}
