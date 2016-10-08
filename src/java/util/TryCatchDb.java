package util;

import java.util.List;

public class TryCatchDb<T> extends SuperDb{
	
	public TryCatchDb(Class entityClass) {
		super(entityClass);
	}

	public	void add(T obj){
		try{
			create(obj);
		}catch(Exception e){
                    System.err.println("util.TryCatchDb.add() 追加処理失敗");
                }
	}
	public	void update(T obj){
		try{
			edit(obj);
		}catch(Exception e){
                    System.err.println("util.TryCatchDb.update() 更新処理失敗" );
                }
		
	}
	public	void delete(T obj){
		try{
			remove(obj);
		}catch(Exception e){
                    System.err.println("util.TryCatchDb.delete() 削除失敗");
                }
	}
	public	T search(Object id){
		return	(T)find(id);
	}
	
	public List<T> getAll() {
		return	findAll();
	}

}
