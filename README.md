# ICD_HCC_Mapping

Data Access Object for Sample Mapping Data
Description
ICD (International Classification of Diseases) codes and HCC (Hierarchical Condition Categories) codes represent very specific and very general medical diagnoses respectively. It is important in the medical data industry to map between these two code systems accurately.
It is your job to provide a Data Access Object that can satisfy the provided requirements given the provided sample data.
Directions
1. Implement a DAO based on the requirements listed below.
2. You are allowed to change the schema of the provided data, but must document the
queries used to transform the data to the new schema.
3. If there are questions unanswered by this requirements document you must decide the
answer yourself and document your reasoning.
4. Please provide any tests you've written with your solution submission.
Required Public APIs
● getHCC
● setHCC
● deleteHCC
● getICD
● setICD
● deleteICD
● getMappedHCCs ● getMappedICDs ● setMapping
● deleteMapping
● getHCCParents ● getHCCChildren


Example Use Cases
● An application that will use this DAO must show a list of ICDs that map to a specific HCC. This list must include the descriptions of the HCC codes.
● A function that will use this DAO will be given a list of HCCs and be expected to filter out any codes that are children of any other codes in the list.
● A function that will use this DAO will be given a list of HCCs and return a list of the associated ICDs for each HCC.
● An API that will use this DAO will take a list of ICDs and map them to HCCs in order to return the sum of all the RAF values.
