import java.sql.Time;

/*Фрекен Снорк кивнула. От страха у нее побелела мордочка. Они принялись что-то бормотать и выписывать круги, притоптывая ногами.
Седьмой круг был самым долгим, потому что теперь им стало по-настоящему жутко. Но если ух начал ворожить в ночь на Иванов день,
то надо продолжать, а то еще неизвестно, чем все кончится.
 */

public class Main {
    public static void main(String[] args) {
        SpecialDate ivanov = new SpecialDate("Иванов день", TimeOfDay.NIGHT);
        MumiTroll snork = new MumiTroll("Фрейкен Снорк");
        MumiTroll notSnork = new MumiTroll("другой мумми-тролль");
        snork.expressEmotion(Emotion.AFRAID);
        snork.nod();
        Ritual ritual = new Ritual(ivanov,7, snork, notSnork);
        ritual.start();
    }
}
