class Query{
	private String select;
	private String from;
	private String where;
	private String orderBy;
	
	public void setSelect(String select) {
		this.select = select;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setWhere(String where) {
		this.where = where;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getSelect() {
		return this.select;
	}
	
	public String getFrom() {
		return this.from;
	}
	
	public String toString() {
		
		String query = "SELECT " + this.select + "FROM " + this.from;
		
		if(this.where != null) {
			query += " WHERE " + this.where;
		}
		
		if(this.orderBy != null) {
			query += " ORDER BY " + this.orderBy;
		}
		
		return query;
	}
	
	
}

class QueryBuilder{
	
	private Query query;
	
	public QueryBuilder() {
		
		this.query = new Query();
	}
	
	public QueryBuilder select(String select) {
		this.query.setSelect(select);
		return this;
	}
	
	public QueryBuilder from(String from) {
		this.query.setFrom(from);
		return this;
	}
	
	public QueryBuilder where(String where) {
		this.query.setWhere(where);
		return this;
	}
	
	public QueryBuilder orderBy(String orderBy) {
		
		this.query.setOrderBy(orderBy);
		return this;
	}
	
	public Query build() {
		
		if(query.getSelect() == null || query.getFrom() == null) {
			throw new IllegalStateException();
		}
		else {
			return query;
		}
	}
}

public class BuilderPattern {
	
	public static void main(String[] args) {
		
		Query q1 = new QueryBuilder().select("name").from("student").build();
		System.out.println(q1.toString());
		
		Query q2 = new QueryBuilder().select("name").from("student").where("name='Name1'").build();
		System.out.println(q2.toString());
		
		Query q3 = new QueryBuilder().select("name").from("student").where("name='Name1'").orderBy("ID").build();
		System.out.println(q3.toString());
		
		Query q4 = new QueryBuilder().from("student").where("name='Name1'").orderBy("ID").build();
		System.out.println(q4.toString());
		
		Query q5 = new QueryBuilder().select("student").where("name='Name1'").orderBy("ID").build();
		System.out.println(q5.toString());
		
		
		
		
	}

}
 