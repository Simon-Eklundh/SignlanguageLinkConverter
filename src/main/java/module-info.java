module com.example.signlanguageconverter {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.signlanguageconverter to javafx.fxml;
	exports com.example.signlanguageconverter;
}