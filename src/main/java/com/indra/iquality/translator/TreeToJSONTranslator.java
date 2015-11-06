package com.indra.iquality.translator;

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

	public JSONObject createJSONFromTreeForjsTree(GenericTreeNode<DictionaryConcept> root){
		
		JSONObject jsonTree = new JSONObject();
		
		jsonTree.put("text", HtmlUtils.htmlEscape(root.getData().getConcept()));
		
		JSONArray children = new JSONArray();

		for (GenericTreeNode<DictionaryConcept> child : root.getChildren()){
			children.add(createJSONFromTreeForjsTree(child));
		}

		jsonTree.put("children", children);
		jsonTree.put("type", root.getData().getTipo());
		
		if(root.getData().getTipo() == ConceptTypeEnum.ATRIBUTO || 
				root.getData().getTipo() == ConceptTypeEnum.ATRIBUTO_MAESTRO ||
				root.getData().getTipo() == ConceptTypeEnum.INDICADOR || 
				root.getData().getTipo() == ConceptTypeEnum.LITERAL){
			
			jsonTree.put("id", "compRowID:" + root.getData().getCompRowID() + "&" + "ctRowID:" + root.getData().getCtRowID());
		}
		
		return jsonTree;
		
	}
	
	public String createPrettyJSONStringFromTreeForjsTree(GenericTreeNode<DictionaryConcept> root){
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(createJSONFromTreeForjsTree(root).toString());
		String prettyJsonString = gson.toJson(je);
		
		return prettyJsonString;
		
	}
}
