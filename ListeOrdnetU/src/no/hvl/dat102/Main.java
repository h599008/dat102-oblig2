package no.hvl.dat102;

import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.Person;
import no.hvl.dat102.tabell.TabellOrdnetListe;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var kjedet = new KjedetOrdnetListe<Person>();
        var tabell = new TabellOrdnetListe<Person>();

        JTextField fornavnField = new JTextField(8);
        JTextField etternavnField = new JTextField(8);
        JTextField foedselsaarField = new JTextField(8);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(new JLabel("Fornavn:"));
        inputPanel.add(fornavnField);
        inputPanel.add(new JLabel("Etternavn:"));
        inputPanel.add(etternavnField);
        inputPanel.add(new JLabel("Fødselsår:"));
        inputPanel.add(foedselsaarField);

        int result;
        do {
            result = JOptionPane.showConfirmDialog(null, inputPanel, "Skriv inn person informasjon:", JOptionPane.OK_CANCEL_OPTION);

            var person = new Person(fornavnField.getText(), etternavnField.getText(), Integer.parseInt(foedselsaarField.getText()));

            if (result == JOptionPane.OK_OPTION) {
                kjedet.leggTil(person);
                tabell.leggTil(person);
            }
        } while (result == JOptionPane.OK_OPTION);

        kjedet.sorter();
        tabell.sorter();

        System.out.println("Kjedet Ordnet Liste:");
        System.out.println(kjedet);

        System.out.println("Tabell Ordnet Liste:");
        System.out.println(tabell);
    }
}
