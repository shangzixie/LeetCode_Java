def replace_underscores_in_file(filename):
    try:
        # Read the content of the file
        with open(filename, 'r') as file:
            modified_lines = []
            for line in file:
                # Find and replace underscores between brackets
                start = line.find('[')
                end = line.find(']')
                if start != -1 and end != -1 and start < end:
                    # Replace underscores with spaces between the brackets
                    part_with_underscores = line[start+1:end]
                    modified_part = part_with_underscores.replace('_', ' ')
                    modified_line = line[:start+1] + modified_part + line[end:]
                    modified_lines.append(modified_line)
                else:
                    modified_lines.append(line)

        # Write the modified content back to the file
        with open(filename, 'w') as file:
            file.writelines(modified_lines)

    except FileNotFoundError:
        print(f"Error: The file '{filename}' does not exist.")
    except Exception as e:
        print(f"An error occurred: {e}")


# Example usage
replace_underscores_in_file('readme.md')
