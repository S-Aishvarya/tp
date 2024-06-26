package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.patient.Name;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.Phone;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Patient> PREDICATE_SHOW_ALL_PATIENTS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' patient list file path.
     */
    Path getPatientListFilePath();

    /**
     * Sets the user prefs' patient list file path.
     */
    void setPatientListFilePath(Path patientListFilePath);

    /**
     * Replaces patient list data with the data in {@code patientList]}.
     */
    void setPatientList(ReadOnlyPatientList patientList);

    /** Returns the PatientList */
    ReadOnlyPatientList getPatientList();

    /**
     * Returns true if a patient with the same identity as {@code patient} exists in the patient list.
     */
    boolean hasPatient(Patient patient);

    /**
     * Returns true if a patient with {@code name} and {@code phone} exists in the patient list.
     */
    boolean hasPatient(Name name, Phone phone);

    /**
     * Deletes the given patient.
     * The patient must exist in the patient list.
     */
    void deletePatient(Patient target);

    /**
     * Adds the given patient.
     * {@code patient} must not already exist in the patient list.
     */
    void addPatient(Patient patient);

    /**
     * Replaces the given patient {@code target} with {@code editedPatient}.
     * {@code target} must exist in the patient list.
     * The patient identity of {@code editedPatient} must not be the same as
     * another existing patient in the patient list.
     */
    void setPatient(Patient target, Patient editedPatient);

    /**
     * Returns the patient with {@code name} and {@code phone} in the patient list.
     */
    Patient getPatient(Name name, Phone phone);

    /** Returns an unmodifiable view of the filtered patient list */
    ObservableList<Patient> getFilteredPatientList();

    /**
     * Updates the filter of the filtered patient list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPatientList(Predicate<Patient> predicate);
}
