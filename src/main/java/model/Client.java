package model;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.validation.SchemaFactory;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Quentin on 23/04/14.
 */
public class Client {

    private Service service;
    private JAXBContext jc;
    private static final QName qname = new QName("", "");
    //private static final String url = "http://auvrayquentinprojetxml.glyceryne.cloudbees.net/rest/cv";
    private static final String url = "http://localhost:8080/AuvrayQuentinProjetXML-1.0-SNAPSHOT/rest/cv";

    private JFrame frame;
    private JButton ajouterCV;
    private JButton CV;
    private JButton allCVs;
    private JButton afficher;
    private JButton saveCV;
    private JTextField numeroCV;
    private JTextArea textArea;
    private JLabel labelCV;
    private JScrollPane scroll;
    private JLabel labelNom;
    private JTextField nomCV;
    private JLabel labelPrenom;
    private JTextField prenomCV;
    private JLabel labelAge;
    private JTextField ageCV;
    private JLabel labelAdresse;
    private JTextField adresseCV;
    private JLabel labelFormations;
    private List<JTextField> formationsCV;
    private JLabel labelExperiences;
    private List<JTextField> experiencesCV;
    private JLabel labelLangues;
    private List<JTextField> languesCV;
    private JLabel labelCompetences;
    private List<JTextField> competencesCV;
    private JLabel labelInterets;
    private List<JTextField> interetsCV;
    private JButton addInterets;
    private JButton addCompetences;
    private JButton addLangues;
    private JButton addExperiences;
    private JButton addFormations;

    public Client() {
        try {
            jc = JAXBContext.newInstance(CV.class);
        } catch (JAXBException je) {

        }
        createView();
        placeComponents(false);
        createController();
        CV.doClick();
    }

    private void createView() {
        frame = new JFrame("CV");
        ajouterCV = new JButton("Ajouter un CV");
        CV = new JButton("CV");
        allCVs = new JButton("Tous les CVs");
        afficher = new JButton("Afficher le CV");
        saveCV = new JButton("Ajouter le CV");
        numeroCV = new JTextField(5);
        textArea = new JTextArea("", 25, 40);
        textArea.setEditable(false);
        labelCV = new JLabel("id du CV : ");
        labelNom = new JLabel("Nom : ");
        nomCV = new JTextField(20);
        labelPrenom = new JLabel("Prénom : ");
        prenomCV = new JTextField(20);
        labelAge = new JLabel("Age : ");
        ageCV = new JTextField(20);
        labelAdresse = new JLabel("Adresse : ");
        adresseCV = new JTextField(20);
        labelFormations = new JLabel("Formations : ");
        formationsCV = new ArrayList<JTextField>();
        formationsCV.add(new JTextField(20));
        labelCompetences = new JLabel("Compétences : ");
        competencesCV = new ArrayList<JTextField>();
        competencesCV.add(new JTextField(20));
        labelLangues = new JLabel("Langues : ");
        languesCV = new ArrayList<JTextField>();
        languesCV.add(new JTextField(20));
        labelExperiences = new JLabel("Expériences : ");
        experiencesCV = new ArrayList<JTextField>();
        experiencesCV.add(new JTextField(20));
        labelInterets = new JLabel("Intérêts : ");
        interetsCV = new ArrayList<JTextField>();
        interetsCV.add(new JTextField(20));
        labelAge.setPreferredSize(new Dimension(88, 16));
        labelNom.setPreferredSize(new Dimension(88, 16));
        labelPrenom.setPreferredSize(new Dimension(88, 16));
        labelAdresse.setPreferredSize(new Dimension(88, 16));
        labelCompetences.setPreferredSize(new Dimension(88, 16));
        labelFormations.setPreferredSize(new Dimension(88, 16));
        labelLangues.setPreferredSize(new Dimension(88, 16));
        labelExperiences.setPreferredSize(new Dimension(88, 16));
        labelInterets.setPreferredSize(new Dimension(88, 16));
        addCompetences = new JButton("+");
        addExperiences = new JButton("+");
        addLangues = new JButton("+");
        addFormations = new JButton("+");
        addInterets = new JButton("+");
        scroll = new JScrollPane();
    }

    private void placeComponents(boolean modeAjout) {
        JPanel p = new JPanel(); {
            JPanel q = new JPanel(new GridLayout(2, 3)); {
                JPanel r = new JPanel(new FlowLayout(FlowLayout.RIGHT)); {
                    r.add(CV);
                }
                q.add(r);
                r = new JPanel(new FlowLayout(FlowLayout.CENTER)); {
                    r.add(allCVs);
                }
                q.add(r);
                r = new JPanel(new FlowLayout(FlowLayout.LEFT)); {
                    r.add(ajouterCV);
                }
                q.add(r);
                r = new JPanel(new FlowLayout(FlowLayout.RIGHT)); {
                    r.add(labelCV);
                }
                q.add(r);
                r = new JPanel(new FlowLayout(FlowLayout.CENTER)); {
                    r.add(numeroCV);
                }
                q.add(r);
                r = new JPanel(new FlowLayout(FlowLayout.LEFT)); {
                    r.add(afficher);
                }
                q.add(r);
            }
            p.add(q);
        }
        frame.add(p, BorderLayout.NORTH);
        modifScroll(modeAjout);
        frame.add(scroll, BorderLayout.CENTER);
        p = new JPanel(); {
            p.add(saveCV);
        }
        frame.add(p, BorderLayout.SOUTH);
    }

    private void modifScroll(boolean modeAjout) {
        JPanel p;
        if (!modeAjout) {
            p = new JPanel(); {
                p.add(textArea);
            }
        } else {
        p = new JPanel(new GridLayout(0, 1)); {
            JPanel q = new JPanel(); {
                q.add(labelNom);
                q.add(nomCV);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelPrenom);
                q.add(prenomCV);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelAge);
                q.add(ageCV);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelAdresse);
                q.add(adresseCV);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelFormations);
                q.add(formationsCV.get(0));
            }
            p.add(q);
            for (int i = 1; i < formationsCV.size(); i++) {
                q = new JPanel(); {
                    JLabel l = new JLabel("");
                    l.setPreferredSize(new Dimension(88, 16));
                    q.add(l);
                    q.add(formationsCV.get(i));
                }
                p.add(q);
            }
            q = new JPanel(); {
                q.add(addFormations);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelExperiences);
                q.add(experiencesCV.get(0));
            }
            p.add(q);
            for (int i = 1; i < experiencesCV.size(); i++) {
                q = new JPanel(); {
                    JLabel l = new JLabel("");
                    l.setPreferredSize(new Dimension(88, 16));
                    q.add(l);
                    q.add(experiencesCV.get(i));
                }
                p.add(q);
            }
            q = new JPanel(); {
                q.add(addExperiences);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelLangues);
                q.add(languesCV.get(0));
            }
            p.add(q);
            for (int i = 1; i < languesCV.size(); i++) {
                q = new JPanel(); {
                    JLabel l = new JLabel("");
                    l.setPreferredSize(new Dimension(88, 16));
                    q.add(l);
                    q.add(languesCV.get(i));
                }
                p.add(q);
            }
            q = new JPanel(); {
                q.add(addLangues);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelCompetences);
                q.add(competencesCV.get(0));
            }
            p.add(q);
            for (int i = 1; i < competencesCV.size(); i++) {
                q = new JPanel(); {
                    JLabel l = new JLabel("");
                    l.setPreferredSize(new Dimension(88, 16));
                    q.add(l);
                    q.add(competencesCV.get(i));
                }
                p.add(q);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(addCompetences);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(labelInterets);
                q.add(interetsCV.get(0));
            }
            p.add(q);
            for (int i = 1; i < interetsCV.size(); i++) {
                q = new JPanel(); {
                    JLabel l = new JLabel("");
                    l.setPreferredSize(new Dimension(88, 16));
                    q.add(l);
                    q.add(interetsCV.get(i));
                }
                p.add(q);
            }
            p.add(q);
            q = new JPanel(); {
                q.add(addInterets);
            }
            p.add(q);
        }
        }
        scroll.getViewport().add(p);
    }

    private void createController() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CV.setEnabled(false);
                allCVs.setEnabled(true);
                ajouterCV.setEnabled(true);
                labelCV.setVisible(true);
                numeroCV.setVisible(true);
                afficher.setVisible(true);
                saveCV.setVisible(false);
                textArea.setText("");
                modifScroll(false);
            }
        });

        allCVs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CV.setEnabled(true);
                allCVs.setEnabled(false);
                ajouterCV.setEnabled(true);
                labelCV.setVisible(false);
                numeroCV.setVisible(false);
                afficher.setVisible(false);
                saveCV.setVisible(false);
                textArea.setText("");
                modifScroll(false);
                try {
                    getCVs();
                } catch (Exception e1) {

                }

            }
        });

        ajouterCV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CV.setEnabled(true);
                allCVs.setEnabled(true);
                ajouterCV.setEnabled(false);
                labelCV.setVisible(false);
                numeroCV.setVisible(false);
                afficher.setVisible(false);
                saveCV.setVisible(true);
                textArea.setText("");
                modifScroll(true);
            }
        });

        afficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idCV = Integer.valueOf(numeroCV.getText());
                    if (idCV >= 0) {
                        getCV(idCV);
                    } else {
                        textArea.setText("Id invalide.");
                    }
                } catch (Exception e1) {
                    textArea.setText("Id invalide.");
                }
            }
        });

        saveCV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    putCV();
                } catch (JAXBException e1) {
                    // Erreur lors de l'enregistrement du CV.
                }
            }
        });

        addCompetences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                competencesCV.add(new JTextField(20));
                modifScroll(true);
            }
        });

        addFormations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formationsCV.add(new JTextField(20));
                modifScroll(true);
            }
        });

        addLangues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                languesCV.add(new JTextField(20));
                modifScroll(true);
            }
        });

        addExperiences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                experiencesCV.add(new JTextField(20));
                modifScroll(true);
            }
        });

        addInterets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interetsCV.add(new JTextField(20));
                modifScroll(true);
            }
        });

    }

    private void putCV() throws JAXBException {
        service = Service.create(qname);
        service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname,
                Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "PUT");

        CV cv = new CV();
        cv.setNom(nomCV.getText());
        cv.setPrenom(prenomCV.getText());
        int age = 0;
        try {
            age = Integer.valueOf(ageCV.getText());
        } catch (NumberFormatException nfe) {

        }
        cv.setAge(age);
        cv.setAdresse(adresseCV.getText());
        for (int i = 0; i < competencesCV.size(); i++) {
            String competence = competencesCV.get(i).getText();
            if (!competence.equals("")) {
                cv.competences.add(competence);
            }
        }
        for (int i = 0; i < experiencesCV.size(); i++) {
            String experience = experiencesCV.get(i).getText();
            if (!experience.equals("")) {
                cv.experiences.add(experience);
            }
        }
        for (int i = 0; i < formationsCV.size(); i++) {
            String formation = formationsCV.get(i).getText();
            if (!formation.equals("")) {
                cv.formations.add(formation);
            }
        }
        for (int i = 0; i < languesCV.size(); i++) {
            String langue = languesCV.get(i).getText();
            if (!langue.equals("")) {
                cv.langues.add(langue);
            }
        }
        for (int i = 0; i < interetsCV.size(); i++) {
            String interet = interetsCV.get(i).getText();
            if (!interet.equals("")) {
                cv.interets.add(interet);
            }
        }
        dispatcher.invoke(new JAXBSource(jc, cv));
        allCVs.doClick();
    }

    private String lireCVs(Document document) {
        String contenu = "";
        NodeList cv = document.getElementsByTagName("cv");
        for (int i = 0; i < cv.getLength(); i++) {
            NodeList nodeList = cv.item(i).getChildNodes();
            contenu += "CV : " + nodeList.item(0).getTextContent();
            contenu += "\nNom : " + nodeList.item(1).getTextContent();
            contenu += "\nPrénom : " + nodeList.item(2).getTextContent();
            contenu += "\nAge : " + nodeList.item(3).getTextContent();
            contenu += "\nAdresse : " + nodeList.item(4).getTextContent();
            NodeList formations = nodeList.item(5).getChildNodes();
            contenu += "\nFormations : ";
            for (int j = 0; j < formations.getLength(); j++) {
                contenu += "\n\t- " + formations.item(j).getTextContent();
            }
            NodeList experiences = nodeList.item(6).getChildNodes();
            contenu += "\nExpériences : ";
            for (int j = 0; j < experiences.getLength(); j++) {
                contenu += "\n\t- " + experiences.item(j).getTextContent();
            }
            NodeList langues = nodeList.item(7).getChildNodes();
            contenu += "\nLangues : ";
            for (int j = 0; j < langues.getLength(); j++) {
                contenu += "\n\t- " + langues.item(j).getTextContent();
            }
            NodeList competences = nodeList.item(8).getChildNodes();
            contenu += "\nCompétences : ";
            for (int j = 0; j < competences.getLength(); j++) {
                contenu += "\n\t- " + competences.item(j).getTextContent();
            }
            NodeList interets = nodeList.item(9).getChildNodes();
            contenu += "\nIntérêts : ";
            for (int j = 0; j < interets.getLength(); j++) {
                contenu += "\n\t- " + interets.item(j).getTextContent();
            }
            contenu += "\n----------------------------------------------------" +
                    "----------------------------------------------------------\n";
        }
        return contenu;
    }

    private void getCV(int idCV) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            textArea.setText("Impossible de récupérer le CV " + idCV + ".");
        }

        try {
            Document document = builder.parse(url + "/" + idCV);
            document.getDocumentElement().normalize();
            textArea.setText(lireCVs(document));
        } catch (Exception e) {
            textArea.setText("Impossible de récupérer le CV " + idCV + ".");
        }
    }

    private void getCVs() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            textArea.setText("Impossible de récupérer les CVs.");
        }

        try {
            Document document = builder.parse(url);
            document.getDocumentElement().normalize();
            textArea.setText(lireCVs(document));
        } catch (Exception e) {
            textArea.setText("Impossible de récupérer les CVs.");
        }
    }

    public void display() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Client().display();
            }
        });
    }

}
