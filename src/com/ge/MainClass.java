package com.ge;

import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ge.auditapi.Audit;

public class MainClass {
	
	private Object[][] getMatrix(List<Object> obj, int rowNum){

		List<Method> getterMethods = getMethodList(obj);
		String propertyName = "";
		Object [][] newArr = new Object[rowNum][getterMethods.size()];
		try {
			for(int i = 0; i<rowNum-1; i++) {
				for(int j = 0; j<getterMethods.size();j++) {
					if(!getterMethods.get(j).invoke(obj.get(i)).equals(getterMethods.get(j).invoke(obj.get(i+1)))) {
						if(!getterMethods.get(j).invoke(obj.get(i)).getClass().getName().startsWith("java.lang")) {
							Method[] methods = getterMethods.get(j).invoke(obj.get(i)).getClass().getDeclaredMethods();
							List<ResultObject> resultList = new ArrayList<ResultObject>();
							if(null != methods) {
								resultList = this.compareFields(methods, (Object)getterMethods.get(j).invoke(obj.get(i)), (Object)getterMethods.get(j).invoke(obj.get(i+1)));
								String changedObject = "";
								propertyName = "";
								int specialChar = 0;
								for(ResultObject result : resultList) {
									if(specialChar == 0) {
										propertyName = Introspector.decapitalize(result.getFieldName().substring(result.getFieldName().startsWith("is")?2:3));
										changedObject = (Object)result.getOldObjectValue() + " to " +(Object)result.getNewObjectValue();
									}else {
										propertyName = propertyName + ", " + Introspector.decapitalize(result.getFieldName().substring(result.getFieldName().startsWith("is")?2:3));
										changedObject = changedObject + " & " + (Object)result.getOldObjectValue() + " to " +(Object)result.getNewObjectValue();
									}
									specialChar++;
								}
								newArr[i][j] = "The " + propertyName + " has been changed from " + changedObject;
							}
						}else {
							propertyName = Introspector.decapitalize(getterMethods.get(j).getName().substring(getterMethods.get(j).getName().startsWith("is")?2:3));
							newArr[i][j] = "The " + propertyName + " has been changed from " + (Object)getterMethods.get(j).invoke(obj.get(i)) + " to " + (Object)getterMethods.get(j).invoke(obj.get(i+1));
						}
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return newArr;
	}

	private List<Method> getMethodList(List<Object> obj) {
		List<Method> getterMethods = new ArrayList<>();
		for(Method method : obj.get(0).getClass().getMethods()) {
			if((method.getName().startsWith("get") || method.getName().startsWith("is"))&& method.getParameterCount() == 0) {
				getterMethods.add(method);
			}
		}
		return getterMethods;
	}
	
	public List<ResultObject> compareFields(Method[] methods, Object obj1, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<ResultObject> resultList =  new ArrayList<ResultObject>();
				for(Method method : methods) {
					if((method.getName().startsWith("get") || method.getName().startsWith("is"))&& method.getParameterCount() == 0) {
						if(!Objects.equals(method.invoke(obj1),method.invoke(obj2))) {
							ResultObject resultObject = new ResultObject();
							resultObject.setFieldName(method.getName());
							resultObject.setOldObjectValue((Object)method.invoke(obj1));
							resultObject.setNewObjectValue((Object)method.invoke(obj2));
							resultList.add(resultObject);
						}
					}
				}
		
		return resultList;
	}
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		Student student1 = new Student();
		student1.setId(1L);
		student1.setFirstName("Vandit");
		student1.setLastName("V");
		student1.setRollNo("A001");
		student1.setResult("Pass");
		student1.setStatus(true);
		Subject subject1 = new Subject();
		subject1.setId(1L);
		subject1.setMaths("Pass");
		subject1.setScience("Pass");
		subject1.setComputer("Fail");
		subject1.setEnglish("Fail");
		student1.setSubject(subject1);
		
		Student student2 = new Student();
		student2.setId(2L);
		student2.setFirstName("Vandit");
		student2.setLastName("J");
		student2.setRollNo("A001");
		student2.setResult("Fail");
		student2.setStatus(true);
		Subject subject2 = new Subject();
		subject2.setId(1L);
		subject2.setMaths("Fail");
		subject2.setScience("Pass");
		subject2.setComputer("Pass");
		subject2.setEnglish("Fail");
		student2.setSubject(subject2);
		
		
		Student student3 = new Student();
		student3.setId(3L);
		student3.setFirstName("Prince");
		student3.setLastName("G");
		student3.setRollNo("A002");
		student3.setResult("Pass");
		student3.setStatus(false);
		Subject subject3 = new Subject();
		subject3.setId(2L);
		subject3.setMaths("Pass");
		subject3.setScience("Pass");
		subject3.setComputer("Pass");
		subject3.setEnglish("Pass");
		student3.setSubject(subject3);
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		MainClass mainClass = new MainClass();
		
		Audit audit = new Audit();
		@SuppressWarnings("unchecked")
		Object [][] finalMatrix = mainClass.getMatrix((List<Object>)(Object)studentList,3);
		
		for(int i = 0; i<finalMatrix.length-1; i++) {
			for(int j= 0 ; j<7;j++) {
				//if(null!=finalMatrix[i][j])
				System.out.println( i + " " + j + " " + finalMatrix[i][j]);
			}
		}
	}
	

}
