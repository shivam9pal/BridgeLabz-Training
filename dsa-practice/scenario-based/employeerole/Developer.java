package week03.scenariobased.employeerole;

class Developer extends Employee{
	private final double bonus;

    public Developer(String name, double salary) {
        super(name, salary);
        if (salary > 50000) {
            this.bonus = salary * 0.05; 
        } else {
            this.bonus = 0.0;
        }
    }

    @Override
    double getBonus() {
        return bonus;
    }
}
