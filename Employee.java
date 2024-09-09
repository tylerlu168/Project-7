public class Employee extends Thread
{
    private TheDrum pallet;
    private int totalJasmine;
    private int totalEarlGrey;
    private int totalLemon;
    private int id;
    private static int nextId;

    public Employee()
    {
        pallet = null;
        totalJasmine = 0;
        totalEarlGrey = 0;
        totalLemon = 0;
        nextId++;
        id = nextId;
    }

    public Employee(TheDrum pallet)
    {
        this.pallet = pallet;
        totalJasmine = 0;
        totalEarlGrey = 0;
        totalLemon = 0;
        nextId++;
        id = nextId;

    }

    public int totalTea()
    {
        int total = totalJasmine + totalEarlGrey + totalLemon;

        return total;
    }

    @Override
    public void run()
    {
        /*while (pallet.getNextTeaBox() != null)
        {
            if(pallet.getNextTeaBox().getTeaType().equals("Jasmine"))
            {
                totalJasmine++;
            }
            if(pallet.getNextTeaBox().getTeaType().equals("Earl Grey"))
            {
                totalEarlGrey++;
            }
            if(pallet.getNextTeaBox().getTeaType().equals("Lemon"))
            {
                totalLemon++;
            }
        }*/

        TeaBox teaBox;
        while ((teaBox = pallet.getNextTeaBox()) != null) {
            String teaType = teaBox.getTeaType();
            if (teaType.equals("Jasmine")) {
                totalJasmine++;
            } else if (teaType.equals("Earl Grey")) {
                totalEarlGrey++;
            } else if (teaType.equals("Lemon")) {
                totalLemon++;
            }
        }

    }

    @Override
    public String toString()
    {
        String output = "";

        output += "Employee " + id + " has unloaded " + totalJasmine + " boxes of Jasmine Tea, " + totalEarlGrey + " boxes of Earl Grey Tea, and " + totalLemon + " boxes of Lemon Tea.";

        return output;
    }



}
