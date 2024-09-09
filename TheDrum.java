public class TheDrum
{
    private TeaBox nextTeaBox;

    private final Object lock = new Object();
    public TheDrum()
    {
        nextTeaBox = null;
    }

    public TheDrum(int jasmine, int earlGrey, int Lemon)
    {
        for (int i = 0; i < jasmine; i++)
        {
            synchronized(lock)
            {
                nextTeaBox = new TeaBox("Jasmine", nextTeaBox);
            }
            //nextTeaBox = new TeaBox("Jasmine", nextTeaBox); //see if i can do synchronized(lock)
        }
        for (int i = 0; i < earlGrey; i++)
        {
            synchronized (lock)
            {
                nextTeaBox = new TeaBox("Earl Grey", nextTeaBox);
            }

        }
        for (int i = 0; i < Lemon; i++)
        {
            synchronized (lock)
            {
                nextTeaBox = new TeaBox("Lemon", nextTeaBox);
            }

        }
    }
    public TeaBox getNextTeaBox() {
        synchronized (lock)
        {
            TeaBox teaBox = nextTeaBox;
            if (teaBox != null) {
                nextTeaBox = teaBox.getNextTea();
            }
            return teaBox;
        }

    }
}
