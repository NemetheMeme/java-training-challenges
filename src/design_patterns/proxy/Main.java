package design_patterns.proxy;

public class Main {
    public static void main(String[] args) {
        RealEstateAgentProxy agent_proxy = new RealEstateAgentProxy();

        Student Poppy = new Student("Poppy", 560);
        Student Miguel = new Student("Miguel", 250);

        Apartment a_corresi_neighbourhood = new Apartment("Coressi Neighbourhood", 450);
        Apartment a_gemenii_neighbourhood = new Apartment("Gemenii Neighbourhood", 220);

        agent_proxy.represent(a_corresi_neighbourhood);
        agent_proxy.represent(a_gemenii_neighbourhood);

        Apartment result_one = agent_proxy.rent(Poppy, a_corresi_neighbourhood);
        System.out.println("Apartment rented : " + result_one);

        Apartment result_two = agent_proxy.rent(Miguel,a_gemenii_neighbourhood);
        System.out.println("Apartment rented: " + result_two);
    }
}
