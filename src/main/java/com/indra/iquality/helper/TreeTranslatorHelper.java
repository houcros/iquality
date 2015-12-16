/*
 * 
 */
package com.indra.iquality.helper;

import java.util.List;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.model.DictionaryConcept;

/**
 * The Class TreeTranslatorHelper. Offers utilities to transform lists to trees,
 * and trees to JSON.
 *
 * @author Ignacio N. Lucero Ascencio
 * @version 0.5, 16-dic-2015
 * 
 *          The Class TreeTranslatorHelper.
 */
public class TreeTranslatorHelper {

	/**
	 * Translates a tree of {@link com.indra.iquality.model.DictionaryConcept}
	 * to its pretty JSON String. That is, a friendly and natural formatted
	 * JSON. The format of the JSON tree is the one expected by the
	 * <a href="https://www.jstree.com/">jsTree plug-in for jQuery</a>.
	 *
	 * @param root
	 *            the root node of the tree
	 * @return the pretty JSON representation of the tree
	 */
	public String treeToPrettyJSONStringForjsTree(GenericTreeNode<DictionaryConcept> root) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(treeToJSONForjsTree(root).toString());
		String prettyJsonString = gson.toJson(je);

		return prettyJsonString;

	}

	/**
	 * Translates a tree of {@link com.indra.iquality.model.DictionaryConcept}
	 * to a JSONObject. The format of the JSON tree is the one expected by the
	 * <a href="https://www.jstree.com/">jsTree plug-in for jQuery</a>.
	 *
	 * @param root
	 *            the root node of the tree
	 * @return the JSONObject representation of the tree
	 */
	public JSONObject treeToJSONForjsTree(GenericTreeNode<DictionaryConcept> root) {

		JSONObject jsonTree = new JSONObject();

		jsonTree.put("text", HtmlUtils.htmlEscape(root.getData().getConcept()));

		JSONArray children = new JSONArray();

		for (GenericTreeNode<DictionaryConcept> child : root.getChildren()) {
			children.add(treeToJSONForjsTree(child));
		}

		jsonTree.put("children", children);
		jsonTree.put("type", root.getData().getType());

		if (root.getData().getType() == ConceptTypeEnum.ATRIBUTO
				|| root.getData().getType() == ConceptTypeEnum.ATRIBUTO_MAESTRO
				|| root.getData().getType() == ConceptTypeEnum.INDICADOR
				|| root.getData().getType() == ConceptTypeEnum.LITERAL) {

			jsonTree.put("id",
					"compRowID:" + root.getData().getCompRowID() + "&" + "ctRowID:" + root.getData().getCtRowID());
		}

		return jsonTree;
	}

	/**
	 * Translates a list of nodes with
	 * {@link com.indra.iquality.model.DictionaryConcept} as its data to a tree.
	 *
	 * @param list
	 *            the list of nodes
	 * @return the root node of the equivalent tree
	 */
	public GenericTreeNode<DictionaryConcept> conceptListToTree(List<GenericTreeNode<DictionaryConcept>> list) {

		// Añado elemento ficticio con altura 0 al inicio de la lista
		// para facilitar el algoritmo
		list.add(0, new GenericTreeNode<DictionaryConcept>(new DictionaryConcept("ROOT", 0)));

		Stack<Integer> S = new Stack<Integer>();
		int index = 1;
		GenericTreeNode<DictionaryConcept> root = list.get(0);
		GenericTreeNode<DictionaryConcept> currentNode = root;

		S.push(Integer.valueOf(root.getData().getLevel()));// Esto es:
															// S.push(0);

		while (index < list.size()) {

			if (list.get(index).getData().getLevel() > list.get(S.peek()).getData().getLevel()) {
				currentNode.addChild(list.get(index));
				currentNode = currentNode.getChildAt(currentNode.getNumberOfChildren() - 1);
				S.push(Integer.valueOf(index));
				++index;
			} else {
				while (!S.isEmpty()
						&& list.get(index).getData().getLevel() <= list.get(S.peek()).getData().getLevel()) {
					S.pop();
					currentNode = currentNode.getParent();
				}
			}
		}

		return root;
	}
}
