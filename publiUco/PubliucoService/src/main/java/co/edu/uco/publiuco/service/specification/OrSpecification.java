package co.edu.uco.publiuco.service.specification;

public class OrSpecification<T> extends CompositeSpecification<T> {
    ISpecification<T> left;
    ISpecification<T> rigth;
    public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
        this.left = left;
        this.rigth = right;
    }
    @Override
    public boolean isSatisfyBy(T candidate) {
        return left.isSatisfyBy(candidate) || rigth.isSatisfyBy(candidate);
    }
}
