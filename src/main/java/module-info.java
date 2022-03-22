module com.example.signlanguageconverter {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;


	opens com.example.signlanguageconverter to javafx.fxml;
	exports com.example.signlanguageconverter;
}