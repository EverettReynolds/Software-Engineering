package prepare;

public class MeasureBean 
{
	/*
	 * The measureData array's indices are organized as follows
	ZyZy
	BaBr
	EuEu
	GlOp
	GoCo
	GoGo
	PoGo
	AlMxF
	Hl
	HPML
	HPAP
	HDML
	HDAP
	RL
	RPML
	RPAP
	RDML
	RDAP
	UL
	FL
	FHL
	FHSI
	FPAP
	FPML
	*/
	
	private String[] measureData = new String[24];
	
	public MeasureBean(String[] measureData)
	{
		this.measureData = measureData;
	}
	
	public String[] getMeasureData()
	{
		return measureData;
	}
}
