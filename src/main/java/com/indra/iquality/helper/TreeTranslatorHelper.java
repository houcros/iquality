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

public class TreeTranslatorHelper {

	public String treeToPrettyJSONStringForjsTree(GenericTreeNode<DictionaryConcept> root) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(treeToJSONForjsTree(root).toString());
		String prettyJsonString = gson.toJson(je);

		return prettyJsonString;

	}

	public JSONObject treeToJSONForjsTree(GenericTreeNode<DictionaryConcept> root) {

		JSONObject jsonTree = new JSONObject();

		jsonTree.put("text", HtmlUtils.htmlEscape(root.getData().getConcept()));

		JSONArray children = new JSONArray();

		for (GenericTreeNode<DictionaryConcept> child : root.getChildren()) {
			children.add(treeToJSONForjsTree(child));
		}

		jsonTree.put("children", children);
		jsonTree.put("type", root.getData().getTipo());

		if (root.getData().getTipo() == ConceptTypeEnum.ATRIBUTO
				|| root.getData().getTipo() == ConceptTypeEnum.ATRIBUTO_MAESTRO
				|| root.getData().getTipo() == ConceptTypeEnum.INDICADOR
				|| root.getData().getTipo() == ConceptTypeEnum.LITERAL) {

			jsonTree.put("id",
					"compRowID:" + root.getData().getCompRowID() + "&" + "ctRowID:" + root.getData().getCtRowID());
		}

		return jsonTree;
	}

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
