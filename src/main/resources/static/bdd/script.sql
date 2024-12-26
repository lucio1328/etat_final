CREATE TABLE exercice(
                         id SERIAL,
                         annee INTEGER NOT NULL,
                         date_debut DATE NOT NULL,
                         date_fin DATE NOT NULL,
                         PRIMARY KEY(id)
);

CREATE TABLE type_compte(
                            id SERIAL,
                            type VARCHAR(50)  NOT NULL,
                            PRIMARY KEY(id)
);

CREATE TABLE compte(
                       numero_compte INTEGER,
                       classe VARCHAR(50)  NOT NULL,
                       intitule INTEGER NOT NULL,
                       id INTEGER NOT NULL,
                       PRIMARY KEY(numero_compte),
                       FOREIGN KEY(id) REFERENCES type_compte(id)
);

CREATE TABLE type_operation(
                               id SERIAL,
                               type VARCHAR(50)  NOT NULL,
                               PRIMARY KEY(id)
);

CREATE TABLE ecriture(
                         id SERIAL,
                         montant NUMERIC(18,2)   NOT NULL,
                         date_saisie DATE NOT NULL,
                         id_1 INTEGER NOT NULL,
                         numero_compte INTEGER NOT NULL,
                         id_2 INTEGER NOT NULL,
                         PRIMARY KEY(id),
                         FOREIGN KEY(id_1) REFERENCES type_operation(id),
                         FOREIGN KEY(numero_compte) REFERENCES compte(numero_compte),
                         FOREIGN KEY(id_2) REFERENCES exercice(id)
);
