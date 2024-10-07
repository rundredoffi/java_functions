

public class Bonbon {
	private String idProduit;
	private String designation;
	private Double prixHorsTaxe;
	public Bonbon() {
		//TODO Auto-generated constructor stub
	}
	public Bonbon(String idProduit, String designation, Double prixHorsTaxe) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.prixHorsTaxe = prixHorsTaxe;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getPrixHorsTaxe() {
		return prixHorsTaxe;
	}
	public void setPrixHorsTaxe(Double prixHorsTaxe) {
		this.prixHorsTaxe = prixHorsTaxe;
	}
	@Override
	public String toString() {
		return "Bonbon [idProduit=" + idProduit + ", designation=" + designation + ", prixHorsTaxe=" + prixHorsTaxe
				+ "€]";
	}

}
