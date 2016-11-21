# jQuery Validation Exercises

Apply the validation rules to the following HTML forms using jQuery.Validate

### Authentication

Username

	Cannot be blank
	Although the field is labeled "Username", it must be an email address, so check to make sure it is formatted as a reasonable email address

Password

	Cannot be blank

### Sign-up for Something Free

Email

	Cannot be blank
	Formatted as a reasonable email address

Password

	Must be at least 8 characters in length
	Must have at least one of each of the following:
		Uppercase letter
		Special character
		Number

Confirm

	Must equal Password

Company

	Cannot be blank

Website

	Can be blank, but if there is something entered, it needs to be formatted as a reasonable URL

Industry

	Must have a selection

Position

	Must have a selection

Number of Employees

	Must have a selection

Barrage my inbox

	Is optional

Send me newsletters I'll never read

	Is optional, but when checked, then all individual newsletters checkboxes are automatically checked along with it. And when unchecked, then all individual newsletters checkboxes are automatically unchecked.

Individual newsletter checkboxes

	Individually optional

### Confidential Information

Birthday

	Cannot be blank.
	Required format is mm/dd/yyyy, includes slashes

SSN (Social Security Number)

	Cannot be blank.
	Required format is 999-99-9999, includes hyphens

Address

	Optional

Second address line (unlabled)

	Optional, but may not be filled if first Address line is blank

City

	Cannot be blank.

State

	Must have a selection

Zip

	Cannot be blank
	Required format is 99999

Gender

	Must have a selection

### Registration

Email

	Cannot be blank
	Formatted as a reasonable email address

First Name

	Cannot be blank

Last Name

	Cannot be blank

Password

	Must be at least 8 characters in length
	Must have at least one of each of the following:
		Uppercase letter
		Special character
		Number

Confirm

	Must equal Password

Country

	Must have a selection

Home Phone

	Cannot be blank
	Required format is 9+ (999)999-9999, includes () and hyphen, country code is optional

Office Phone

	Cannot be blank
	Required format is 9+ (999)999-9999, includes () and hyphen, country code is optional

Cell Phone

	Cannot be blank
	Required format is 9+ (999)999-9999, includes () and hyphen, country code is optional
