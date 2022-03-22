package com.example.signlanguageconverter;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SignLanguageConverterController {
	Database database = new Database();
	@FXML
	private TextField input;
	@FXML
	private TextArea current;
	@FXML
	private TextArea result;

	@FXML
	protected void onAddButtonClick(){
		String resulting = database.add(input.getText());
		if(resulting!=null) {
			current.appendText(resulting + "\n");
			input.clear();
			input.setPromptText("link successfully added");
		}
	}
	@FXML
	protected void onRemoveButtonClick(){
		String resulting = database.remove(input.getText());
		if(resulting != null){
			current.setText(resulting);
			input.clear();
			input.setPromptText("link successfully removed");
		}

	}
	@FXML
	protected void onRemoveAllDataButtonClick(){
		database.clear();
		current.clear();

	}
	@FXML
	protected void onConvertToLexikonButtonClick(){
		String result = database.getLexicon();
		if(result!=null){
			this.result.setText(result);
		}

	}
	@FXML
	protected void onConvertToImportButtonClick(){
		String result = database.getImportText();
		if(result!=null){
			this.result.setText(result);
		}
	}



}