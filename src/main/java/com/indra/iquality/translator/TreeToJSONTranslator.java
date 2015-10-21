package com.indra.iquality.translator;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.indra.iquality.model.ConceptTypeEnum;
import com.indra.iquality.model.DictionaryConcept;
import com.indra.iquality.tree.GenericTreeNode;

public class TreeToJSONTranslator {

	public JSONObject createJSONFromTree(GenericTreeNode<DictionaryConcept> root){
		
		JSONObject jsonTree = new JSONObject();
		
		jsonTree.put("name", HtmlUtils.htmlEscape(root.getData().getConcept()) +  "<div class=\"tree-actions\"></div>");
//		jsonTree.put("name", root.getData().getConcept() +  "<div class=\"tree-actions\"></div>");
		if(root.getData().getTipo() == ConceptTypeEnum.SECCION
				|| root.getData().getTipo() == ConceptTypeEnum.MODELO
				|| root.getData().getTipo() == ConceptTypeEnum.ENTIDAD
				|| root.getData().getTipo() == ConceptTypeEnum.DIMENSION
				|| root.getData().getTipo() == ConceptTypeEnum.JERARQUIA){
			
			jsonTree.put("type", "folder");
		}
		else{
			jsonTree.put("type", "item");
		}
		
		
		if(root.hasChildren()){
			JSONArray children = new JSONArray();

			//		ListIterator<GenericTreeNode<DictionaryConcept>> li = root.getChildren().listIterator(root.getChildren().size());
			//		while(li.hasPrevious()){
			//			children.add(createJSONFromTree(li.previous()));
			//		}

			for (GenericTreeNode<DictionaryConcept> child : root.getChildren()){
				children.add(createJSONFromTree(child));
			}

			jsonTree.put("data", children);
		}
		
		return jsonTree;
	}
	
	public String createPrettyJSONStringFromTree(GenericTreeNode<DictionaryConcept> root){
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(createJSONFromTree(root).toString());
		String prettyJsonString = gson.toJson(je);
		
		return prettyJsonString;
		
	}
}
