package bridge;

/**
 * decouple the functional abstraction from the implementation so that the two
 * can vary independently without bridge pattern
 * 
 * 
 * Vehicle | car bike | | produce Assemble produce Assemble
 * 
 * 
 * With Bridge Pattern
 * 
 * Vehicle------------ WorkShop | | car bike produce Assemble
 * 
 * 
 */
public abstract class Bridge {
	protected Workshop workShop1;
	protected Workshop workShop2;

	protected Bridge(Workshop workShop1, Workshop workShop2) {
		this.workShop1 = workShop1;
		this.workShop2 = workShop2;
	}

	abstract public void manufacture();

}
