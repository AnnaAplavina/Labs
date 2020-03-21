import java.sql.Time;

/*Фрекен Снорк кивнула. От страха у нее побелела мордочка. Они принялись что-то бормотать и выписывать круги, притоптывая ногами.
Седьмой круг был самым долгим, потому что теперь им стало по-настоящему жутко. Но если ух начал ворожить в ночь на Иванов день,
то надо продолжать, а то еще неизвестно, чем все кончится.
 */

public class Main {
    public static void main(String[] args) {
        SpecialDate ivanov = new SpecialDate("Иванов день", TimeOfDay.NIGHT);
        MumiTroll snork = new MumiTroll("Snork");
        MumiTroll notSnork = new MumiTroll("NotSnork");
        snork.expressEmotion(Emotion.AFRAID);
        snork.nod();
        Ritual ritual = new Ritual(ivanov,7, snork, notSnork);
        ritual.start();
    }
}