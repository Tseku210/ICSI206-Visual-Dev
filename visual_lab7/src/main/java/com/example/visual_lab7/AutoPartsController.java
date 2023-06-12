package com.example.visual_lab7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AutoPartsController {

    TreeItem<String> rootItem;

    @FXML
    private TreeView<String> tvAutoParts;
    ObservableList<PartDescription> items;

    @FXML
    void initialize() {
        rootItem = new TreeItem<>("College Park Auto-Parts");
        rootItem.setExpanded(true);
        tvAutoParts.setRoot(rootItem);
        createYearsTreeItems();
        items = getDescriptions();

        for (PartDescription part : items) {
            Integer partYear = part.getYear();
            for (TreeItem<String> year : rootItem.getChildren()) {
                if (partYear.equals(year.getValue())) {
                    String partMake = part.getMake();
                    if (year.getChildren().isEmpty()) {
                        year.getChildren().add(new TreeItem<>(partMake));
                    } else {
                        String partModel = part.getModel();
                        if (year.getChildren().contains(partMake)) {

                        } else {
                            year.getChildren().add(new TreeItem<>(partMake));
                        }
                    }
                }
            }
        }
    }

    void createYearsTreeItems() {
        for (int year = 1960; year < LocalDate.now().getYear(); year++) {
            TreeItem<String> treeItem = new TreeItem(year);
            rootItem.getChildren().add(treeItem);
        }
    }

    ObservableList<PartDescription> getDescriptions() {
        PartDescription[] parts = new PartDescription[56];
        parts[0] = new PartDescription(447093, 2002, "Ford",
                "Escort SE L4 2.0", "Engine Electrical",
                "Alternator 75amp  Remanufactured; w/ 75 Amp",
                205.05);
        parts[1] = new PartDescription(203815, 2006, "Dodge",
                "Caravan SE L4 2.4", "Cooling System",
                "Radiator Cap", 6.65);;
        parts[2] = new PartDescription(293047, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Gasket", 4.95);
        parts[3] = new PartDescription(990468, 2002, "Honda",
                "Civic 1.7 EX 4DR", "Exhaust",
                "Bolt & Spring Kit (Manifold outlet, Muffler Inlet)",
                85.75);
        parts[4] = new PartDescription(304158, 1996, "Buick",
                "Regal Custom V6 3.8", "Fuel Injection",
                "Fuel Injector", 82.75);
        parts[5] = new PartDescription(807245, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "CV Boot Clamp 7 x 750mm; 1 Large + 1 Small Clamp",
                1.6);
        parts[6] = new PartDescription(203485, 2001, "Ford",
                "Taurus LX V6 3.0", "Fuel Injection",
                "Oxygen Sensor OE Style 4Wire; Front; 2 Required",
                52.65);
        parts[7] = new PartDescription(248759, 1999, "Jeep",
                "Wrangler Sahara", "Air Intake",
                "Air Filter AirSoft Panel", 7.95);
        parts[8] = new PartDescription(202848, 1998, "Honda",
                "Accord 2.3 LX 4DR", "Air Intake",
                "Air Filter", 12.55);
        parts[10] = new PartDescription(932759, 2006, "Kia",
                "Rio 1.6DOHC16V 4-DR", "Cooling System",
                "Thermostat", 14.45);
        parts[11] = new PartDescription(304975, 2000, "Honda",
                "Civic 1.6 EX 4DR", "Suspension",
                "Ball Joint; Front Lower; 2 per car", 40.55);
        parts[12] = new PartDescription(208450, 2003, "Chevrolet",
                "Monte Carlo LS V6 3.4", "Fuel Injection",
                "Oxygen Sensor OE connector; Rear", 65.55);
        parts[13] = new PartDescription(209480, 2002, "Ford",
                "Focus SE DOHC L4 2.0", "Steering",
                "Steering Rack Remanufactured", 170.85);
        parts[9] = new PartDescription(203495, 2004, "Honda",
                "Civic 1.7 EX 4DR", "Climate Control",
                "A/C Clutch; OE compressor = Sanden", 184.95);
        parts[14] = new PartDescription(203480, 2007, "Toyota",
                "Corolla", "Air Intake",
                "Air Filter", 12.65);
        parts[15] = new PartDescription(109379, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Fuel Delivery",
                "Fuel Filter; Early Design; Outer Diameter = 55mm",
                30.95);
        parts[16] = new PartDescription(935794, 2002, "Ford",
                "Escape XLS 4WD", "Brake",
                "Brake Caliper Remanufactured; Front Right",
                65.55);
        parts[17] = new PartDescription(203485, 2006, "BMW",
                "325i", "Climate Control",
                "AC High Pressure Side Switch",
                49.95);
        parts[18] = new PartDescription(204875, 1996, "Chevrolet",
                "Monte Carlo Z34 V6 3.4", "Fuel Delivery",
                "Fuel Filter", 8.05);
        parts[19] = new PartDescription(937485, 2007, "Toyota",
                "Camry V6", "Air Intake", "Air Filter", 12.95);
        parts[20] = new PartDescription(294759, 2001, "Ford",
                "Escape XLT 4WD", "Air Intake",
                "Air Filter Panel", 7.25);
        parts[21] = new PartDescription(297495, 2003, "Honda",
                "Civic 1.7 EX 4DR", "Brake",
                "Brake Caliper Reman; w/ ProAct Pads; Front Right",
                82.55);
        parts[22] = new PartDescription(794735, 2006, "BMW",
                "325i", "Climate Control",
                "Cabin Air/Pollen Filter; With Activated Carbon",
                28.05);
        parts[23] = new PartDescription(937485, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Halogen  SilverStar; 12V 65W; inner-high beam",
                22.85);
        parts[24] = new PartDescription(492745, 2005, "Ford",
                "Focus ZX3 L4 2.0", "Air Intake",
                "Fuel Injection Perf Kit", 342.95);
        parts[25] = new PartDescription(937005, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "CV Boot Clamp 7 x 750mm; For Large End of Boot; inner boot",
                1.6);
        parts[26] = new PartDescription(293749, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Axle Nut 24mm x 1;5; rear ", 2.35);
        parts[27] = new PartDescription(920495, 2006, "BMW",
                "325i", "Climate Control",
                "Adjustable Telescoping Mirror", 7.95);
        parts[28] = new PartDescription(204075, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Wheel Bearing; Rear; 1 per wheel", 70.15);
        parts[29] = new PartDescription(979304, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Housing", 20.95);
        parts[30] = new PartDescription(300456, 2004, "Acura",
                "MDX 3.5 4WD", "Driveshaft & Axle",
                "Wheel Bearing; Front; 1 per wheel",
                66.65);
        parts[31] = new PartDescription(404860, 2001, "Ford",
                "Taurus LX V6 3.0", "Suspension",
                "Shock Absorber GR2; Rear; Wagon only",
                39.4);
        parts[32] = new PartDescription(585688, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Brake",
                "Climate Control", 10.65);
        parts[33] = new PartDescription(739759, 2001, "Ford",
                "Taurus LX V6 3.0", "Suspension",
                "Shock Absorber GasaJust; Rear; Wagon only",
                30.95);
        parts[34] = new PartDescription(927495, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Timing Belt Idler Pulley Original Equipment INA",
                65.55);
        parts[40] = new PartDescription(979374, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Thermostat Gasket", 4.95);
        parts[35] = new PartDescription(542347, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Brake",
                "Brake Pad Set ProACT Ceramic w/Shims; Front", 80.05);
        parts[36] = new PartDescription(683064, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Hose; Upper", 103.75);
        parts[37] = new PartDescription(248759, 1999, "Jeep",
                "Wrangler Sahara", "Air Intake",
                "Air Filter", 50.95);
        parts[38] = new PartDescription(973974, 2007, "Toyota",
                "Corolla", "Air Intake",
                "Air Mass Meter; W/o Housing; Meter/sensor only",
                134.95);
        parts[39] = new PartDescription(285800, 2001, "Ford",
                "Escape XLT 4WD", "Transmission",
                "AT Filter", 34.95);
        parts[41] = new PartDescription(207495, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Headlight Bulb; 12V 65W; inner-high beam", 9.35);
        parts[42] = new PartDescription(566676, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Auxiliary Fan Switch", 42.95);
        parts[43] = new PartDescription(304950, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Headlight Bulb; 12V 51W; outer", 7.85);
        parts[44] = new PartDescription(797394, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Water Flange Gasket", 0.85);
        parts[45] = new PartDescription(910203, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Strut Mount Inc; Sleeve; Rear Right", 80.85);
        parts[46] = new PartDescription(790794, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Hose; Lower", 9.45);
        parts[47] = new PartDescription(970394, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Coil Spring Insulator; Front Lower", 14.55);
        parts[48] = new PartDescription(290840, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Rod Bearing Set 1 per Rod; Standard; Reqs. 5-per Engine",
                26.95);
        parts[49] = new PartDescription(209704, 2007, "Toyota",
                "Corolla", "Body Electrical",
                "Wiper Blade Excel+; Front Right", 7.25);
        parts[50] = new PartDescription(200368, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator Drain Plug incl; gasket", 3.15);
        parts[51] = new PartDescription(200970, 2005, "Volvo",
                "S40 2.5L T5 AWD", "Engine Mechanical",
                "Reference Sensor; Flywheel Engine Speed",
                62.05);
        parts[52] = new PartDescription(542347, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Air Intake",
                "Air Filter", 50.25);
        parts[53] = new PartDescription(927045, 2001, "Ford",
                "Escape XLT 4WD", "Air Intake",
                "Air Filter", 62.95);
        parts[54] = new PartDescription(990659, 2000, "Toyota",
                "RAV4 2WD/4-DOOR", "Cooling System",
                "Radiator OE Plastic tank", 136.85);
        parts[55] = new PartDescription(440574, 2007, "Buick",
                "Lacrosse CXS V6 3.6", "Suspension",
                "Strut Mount Inc; Sleeve; Rear Left",
                80.8);

        ObservableList<PartDescription> list = FXCollections.observableList(Arrays.asList(parts));

        return list;
    }

}