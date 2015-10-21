package com.indra.iquality.translator;
import java.util.List;
import java.util.Stack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.common.base.Charsets;
import com.google.common.io.*;
import com.indra.iquality.helper.CustomHelper;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

public class ConceptsToTreeTranslator {

	final private static CustomHelper helper = new CustomHelper();
	
	public GenericTreeNode<DictionaryConcept> createTreeFromList(List<ParIntNodo> list){
		
		// Añado elemento ficticio con altura 0 al inicio de la lista
		// para facilitar el algoritmo
		list.add(0, new ParIntNodo(0, new GenericTreeNode<DictionaryConcept>(new DictionaryConcept("ROOT"))));
		
		Stack<Integer> S = new Stack<Integer>();
		int index = 1;
		GenericTreeNode<DictionaryConcept> root = list.get(0).getNodo();
		GenericTreeNode<DictionaryConcept> currentNode = root;
		
		S.push(0);
		// Equivalente y quizás más claro?
//		S.push(Integer.valueOf(root.getData().getLevel()));
		
		while (index < list.size()){
			
//			System.out.println("index = " + index +
//					" list level = " + list.get(index).getLevel() +
//					" top stack level = " + list.get(S.peek()).getLevel());
			
			if(list.get(index).getLevel() > list.get(S.peek()).getLevel()){
				currentNode.addChild(list.get(index).getNodo());
//				System.out.println("currentNode tiene " + currentNode.getNumberOfChildren() + " hijos");
				
				// La línea de abajo es equivalente a
				// currentNode = list.get(position).getNodo() [???]
				currentNode = currentNode.getChildAt(currentNode.getNumberOfChildren() - 1);
//				System.out.println("Ahora currentNode es " + currentNode);
				S.push(Integer.valueOf(index));
				
				++index;
			}
			else{
				while(!S.isEmpty() && list.get(index).getLevel() <= list.get(S.peek()).getLevel()){
//					System.out.println("popped out " + list.get(S.peek()).getLevel());
					S.pop();
					currentNode = currentNode.getParent();
				}
			}
		}
		
		return root;
	}

	public GenericTreeNode<DictionaryConcept> createTreeFromFile(String pathToSourceFile) throws NumberFormatException, Exception{
		
		// Esta línea puede lanzar un error de getDictionaryConceptsFromFile
		// por culpa de helper.conceptTypeStringToEnum
		List<ParIntNodo> list = getDictionaryConceptsFromFile(pathToSourceFile);
		
		// Añado elemento ficticio con altura 0 al inicio de la lista
		// para facilitar el algoritmo
		list.add(0, new ParIntNodo(0, new GenericTreeNode<DictionaryConcept>(new DictionaryConcept("ROOT"))));
		
		Stack<Integer> S = new Stack<Integer>();
		int index = 1;
		GenericTreeNode<DictionaryConcept> root = list.get(0).getNodo();
		GenericTreeNode<DictionaryConcept> currentNode = root;
		
		S.push(0);
		// Equivalente y quizás más claro?
//		S.push(Integer.valueOf(root.getData().getLevel()));
		
		while (index < list.size()){
			
//			System.out.println("index = " + index +
//					" list level = " + list.get(index).getLevel() +
//					" top stack level = " + list.get(S.peek()).getLevel());
			
			if(list.get(index).getLevel() > list.get(S.peek()).getLevel()){
				currentNode.addChild(list.get(index).getNodo());
//				System.out.println("currentNode tiene " + currentNode.getNumberOfChildren() + " hijos");
				
				// La línea de abajo es equivalente a
				// currentNode = list.get(position).getNodo() [???]
				currentNode = currentNode.getChildAt(currentNode.getNumberOfChildren() - 1);
//				System.out.println("Ahora currentNode es " + currentNode);
				S.push(Integer.valueOf(index));
				
				++index;
			}
			else{
				while(!S.isEmpty() && list.get(index).getLevel() <= list.get(S.peek()).getLevel()){
//					System.out.println("popped out " + list.get(S.peek()).getLevel());
					S.pop();
					currentNode = currentNode.getParent();
				}
			}
		}
		
		return root;
	}
	
	private List<ParIntNodo> getDictionaryConceptsFromFile(String pathToSourceFile) throws NumberFormatException, Exception{
		
		List<ParIntNodo> filasQuery = new ArrayList<ParIntNodo>();
		
		final File sourceFile = new File(pathToSourceFile);
		try {
			List<String> fileRows = Files.readLines(sourceFile, Charsets.UTF_8);
			for (String fileRow : fileRows){
				// Cada fila tiene el formato:
				// [level] [status] [tipo] [concepto]
				// Esta ordenación está definida en BaseController.testDictionary (349)
				if (fileRow != null && !fileRow.isEmpty()){
					String[] elems = fileRow.split(" ", 4);
					
					// helper.conceptTypeStringToEnum puede lanzar un error
					DictionaryConcept concept = 
							new DictionaryConcept(elems[3], Integer.parseInt(elems[0]), 
								Integer.parseInt(elems[1]), helper.conceptTypeStringToEnum(elems[2]));
					
					GenericTreeNode<DictionaryConcept> conceptNode = new GenericTreeNode<DictionaryConcept>(concept);
					ParIntNodo par = new ParIntNodo(Integer.valueOf(elems[0]), conceptNode);
					filasQuery.add(par);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filasQuery;
	}

	private void testPrintFilas(List<ParIntNodo> list, int amountToPrint){
		
		int count = 0;
		for(ParIntNodo elem : list){
			if (count >= amountToPrint) break;
			System.out.println(elem);
			++count;
		}
	}

	public void sampleTest() {
		
		List<ParIntNodo> filasQuery;
		try {
			// Esta línea puede lanzar un error de getDictionaryConceptsFromFile
			// por culpa de helper.conceptTypeStringToEnum
			filasQuery = getDictionaryConceptsFromFile("C:/Users/inlucero/Documents/iQuality/resultadoQueryDiccionario.txt");
			
//			testPrintFilas(filasQuery, 20);

			List<ParIntNodo> shortFilasQuery = filasQuery.subList(0, filasQuery.size() - 1);
			GenericTreeNode<DictionaryConcept> tree = createTreeFromList(shortFilasQuery);
			
			System.out.println("\n\n\n");
			tree.myPrintTree(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excepción en ConceptsToTreeTranslator.sampleTest.getDictionaryConceptsFromFile:\n");
			e.printStackTrace();
		}

	}
}
